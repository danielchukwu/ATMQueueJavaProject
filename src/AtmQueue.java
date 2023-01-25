import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;

public class AtmQueue {

    public static void main(String[] args) {
        AtmQueue atmQueue = new AtmQueue();
        atmQueue.createapp();
    }

    public void createapp() {
        // Create Queue
        Queue<String> queue = new LinkedList<String>();

        // Create Frame
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(4, 1));
        frame.setSize(300, 450);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Text Fields
        JTextField nameInputField = new JTextField();

        // Add Button
        JButton addButton = new JButton("Add To Queue");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nameInputField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "YOU MUST ENTER A NAME!");
                    return;
                }
                // Add to Queue
                String nameEntered = nameInputField.getText();
                queue.add(nameEntered);
                JOptionPane.showMessageDialog(null, nameEntered + " Just joined the Queue");
                System.out.println(nameEntered + " Just joined the Queue");
                nameInputField.setText("");
            }
        });

        // Remove Button
        JButton removeButton = new JButton("Remove From Queue");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if queue is empty
                if (queue.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "The Queue is Empty");
                    return;
                }
                // Remove from Queue
                String removedName = queue.remove();
                JOptionPane.showMessageDialog(null, removedName + " has been removed from the Queue");
                System.out.println(removedName + " has been removed from the Queue");
            }
        });

        // Print Queue Button
        JButton printQueueButton = new JButton("Print Queue");
        printQueueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (queue.isEmpty()){
                    JOptionPane.showMessageDialog(null, "The Queue is Empty");
                    return;
                }
                // Print Queue
                printQueue(queue);
            }
        });


        // Add Components to Frame
        frame.add(nameInputField);
        frame.add(addButton);
        frame.add(removeButton);
        frame.add(printQueueButton);

        // Make frame visible
        frame.setVisible(true);
    }

    // This method prints out the content of a queue
    public void printQueue(Queue queue) {
        int count = 0;
        System.out.println("\nATM Queuers: ");

        for(Object item : queue) {
            count++;
            System.out.println(count + ". " + item);
        }
    }
}

