package com.cs180.concurrency.synchronization;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates thread synchronization using join() to search for a value across multiple data sources.
 * Simulates searching for a student across multiple file servers concurrently.
 */
public class FileSearchDemo {

    static class Student {
        private int id;
        private String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getID() { return id; }
        public String getName() { return name; }

        @Override
        public String toString() {
            return String.format("Student{id=%d, name='%s'}", id, name);
        }
    }

    /**
     * Simulates a file server containing student records
     */
    static class FileServer {
        private List<Student> students;
        private String serverName;

        public FileServer(String name) {
            this.serverName = name;
            this.students = new ArrayList<>();
        }

        public void addStudent(Student s) {
            students.add(s);
        }

        public String getName() { return serverName; }
        public List<Student> getStudents() { return students; }
    }

    /**
     * Thread that searches for a student on a specific file server
     */
    static class FindStudent implements Runnable {
        private static volatile Student foundStudent = null;
        private static volatile boolean found = false;
        private static int targetStudentId;

        private FileServer fileserver;

        public FindStudent(FileServer fileserver) {
            this.fileserver = fileserver;
        }

        public static Student search(int studentId, FileServer... servers) throws StudentNotFoundException {
            targetStudentId = studentId;
            foundStudent = null;
            found = false;

            System.out.printf("Searching for student ID %d across %d servers...\n", studentId, servers.length);

            Thread[] threads = new Thread[servers.length];

            // Create and start all search threads
            for (int i = 0; i < servers.length; i++) {
                threads[i] = new Thread(new FindStudent(servers[i]));
                threads[i].start();
            }

            // Wait for all threads to complete
            try {
                for (Thread thread : threads) {
                    thread.join();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (found) {
                return foundStudent;
            } else {
                throw new StudentNotFoundException("Student " + studentId + " not found");
            }
        }

        public void run() {
            System.out.printf("Thread searching %s...\n", fileserver.getName());

            for (Student student : fileserver.getStudents()) {
                if (found) {
                    System.out.printf("Thread on %s stopping early - student found elsewhere\n", fileserver.getName());
                    return;
                }

                // Simulate some processing time
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (student.getID() == targetStudentId) {
                    foundStudent = student;
                    found = true;
                    System.out.printf("*** Student found on %s! ***\n", fileserver.getName());
                    return;
                }
            }

            System.out.printf("Thread finished searching %s - not found\n", fileserver.getName());
        }
    }

    static class StudentNotFoundException extends Exception {
        public StudentNotFoundException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Thread Synchronization with join(): File Search ===\n");

        // Create file servers with student data
        FileServer server1 = new FileServer("Server-East");
        server1.addStudent(new Student(1001, "Alice"));
        server1.addStudent(new Student(1002, "Bob"));
        server1.addStudent(new Student(1003, "Charlie"));

        FileServer server2 = new FileServer("Server-West");
        server2.addStudent(new Student(2001, "Diana"));
        server2.addStudent(new Student(2002, "Eve"));
        server2.addStudent(new Student(2003, "Frank"));

        FileServer server3 = new FileServer("Server-Central");
        server3.addStudent(new Student(3001, "Grace"));
        server3.addStudent(new Student(3002, "Henry"));
        server3.addStudent(new Student(3003, "Iris"));

        // Search for existing student
        try {
            System.out.println("Test 1: Searching for existing student\n");
            Student result = FindStudent.search(2002, server1, server2, server3);
            System.out.printf("\nResult: %s\n\n", result);
        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // Search for non-existing student
        try {
            System.out.println("==========================================");
            System.out.println("Test 2: Searching for non-existing student\n");
            Student result = FindStudent.search(9999, server1, server2, server3);
            System.out.printf("\nResult: %s\n", result);
        } catch (StudentNotFoundException e) {
            System.out.printf("\nResult: %s\n", e.getMessage());
        }
    }
}
