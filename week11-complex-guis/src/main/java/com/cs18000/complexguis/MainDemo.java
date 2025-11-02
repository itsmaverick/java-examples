package com.cs18000.complexguis;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.cs18000.complexguis.basic.EmptyFrame;
import com.cs18000.complexguis.events.PushMeButton;
import com.cs18000.complexguis.events.AnonymousInnerClassDemo;
import com.cs18000.complexguis.layouts.FlowLayoutExample;
import com.cs18000.complexguis.layouts.GridLayoutExample;
import com.cs18000.complexguis.layouts.BorderLayoutExample;
import com.cs18000.complexguis.layouts.SubPanelExample;
import com.cs18000.complexguis.graphics.GraphicsDemo;
import com.cs18000.complexguis.mvc.MVCDemo;

/**
 * Main launcher for Week 11 Complex GUIs demonstrations.
 * Provides a menu to launch each example program.
 *
 * Based on Week 11 lecture slides - Complex GUIs
 */
public class MainDemo {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI();
            }
        });
    }

    public static void createGUI() {
        JFrame frame = new JFrame("Week 11 - Complex GUIs Demos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel panel = new JPanel(new GridLayout(0, 1, 10, 10));

        // Basic Examples
        JButton emptyFrameBtn = new JButton("1. Empty Frame (Basic JFrame)");
        emptyFrameBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EmptyFrame.main(null);
            }
        });
        panel.add(emptyFrameBtn);

        // Event Handling Examples
        JButton pushMeBtn = new JButton("2. Push Me Button (ActionListener)");
        pushMeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PushMeButton.main(null);
            }
        });
        panel.add(pushMeBtn);

        JButton anonymousBtn = new JButton("3. Anonymous Inner Class Demo");
        anonymousBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AnonymousInnerClassDemo.main(null);
            }
        });
        panel.add(anonymousBtn);

        // Layout Examples
        JButton borderLayoutBtn = new JButton("4. BorderLayout Example");
        borderLayoutBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BorderLayoutExample.main(null);
            }
        });
        panel.add(borderLayoutBtn);

        JButton flowLayoutBtn = new JButton("5. FlowLayout Example");
        flowLayoutBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FlowLayoutExample.main(null);
            }
        });
        panel.add(flowLayoutBtn);

        JButton gridLayoutBtn = new JButton("6. GridLayout Example");
        gridLayoutBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GridLayoutExample.main(null);
            }
        });
        panel.add(gridLayoutBtn);

        JButton subPanelBtn = new JButton("7. SubPanel & BorderFactory Example");
        subPanelBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SubPanelExample.main(null);
            }
        });
        panel.add(subPanelBtn);

        // Graphics Examples
        JButton graphicsBtn = new JButton("8. Graphics2D Demo");
        graphicsBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        GraphicsDemo.createGUI();
                    }
                });
            }
        });
        panel.add(graphicsBtn);

        // MVC Example
        JButton mvcBtn = new JButton("9. MVC Pattern Demo");
        mvcBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MVCDemo.main(null);
            }
        });
        panel.add(mvcBtn);

        frame.add(panel);
        frame.setVisible(true);
    }
}
