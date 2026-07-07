import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToDoApp extends JFrame {

    private JTextField taskField;
    private DefaultListModel<String> taskModel;
    private JList<String> taskList;
    private JButton addButton;
    private JButton deleteButton;
    private JButton clearButton;

    public ToDoApp() {

        setTitle("To-Do List Application");
        setSize(500, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout(10,10));

        // Top Panel
        JPanel topPanel = new JPanel(new BorderLayout(5,5));

        taskField = new JTextField();

        addButton = new JButton("Add Task");

        topPanel.add(taskField, BorderLayout.CENTER);
        topPanel.add(addButton, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);

        // Center Panel
        taskModel = new DefaultListModel<>();

        taskList = new JList<>(taskModel);

        JScrollPane scrollPane = new JScrollPane(taskList);

        add(scrollPane, BorderLayout.CENTER);

        // Bottom Panel
        JPanel bottomPanel = new JPanel();

        deleteButton = new JButton("Delete Selected");

        clearButton = new JButton("Clear All");

        bottomPanel.add(deleteButton);
        bottomPanel.add(clearButton);

        add(bottomPanel, BorderLayout.SOUTH);

        // Add Task
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String task = taskField.getText().trim();

                if(task.isEmpty()) {

                    JOptionPane.showMessageDialog(
                            ToDoApp.this,
                            "Please enter a task.",
                            "Warning",
                            JOptionPane.WARNING_MESSAGE
                    );

                } else {

                    taskModel.addElement(task);

                    taskField.setText("");

                }

            }
        });

        // Press Enter to Add
        taskField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addButton.doClick();
            }
        });

        // Delete Task
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int index = taskList.getSelectedIndex();

                if(index != -1) {

                    taskModel.remove(index);

                } else {

                    JOptionPane.showMessageDialog(
                            ToDoApp.this,
                            "Please select a task to delete.",
                            "Warning",
                            JOptionPane.WARNING_MESSAGE
                    );

                }

            }
        });

        // Clear All
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(taskModel.size() == 0){

                    JOptionPane.showMessageDialog(
                            ToDoApp.this,
                            "Task list is already empty."
                    );

                    return;
                }

                int option = JOptionPane.showConfirmDialog(
                        ToDoApp.this,
                        "Clear all tasks?",
                        "Confirmation",
                        JOptionPane.YES_NO_OPTION
                );

                if(option == JOptionPane.YES_OPTION){

                    taskModel.clear();

                }

            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ToDoApp();
            }
        });

    }

}