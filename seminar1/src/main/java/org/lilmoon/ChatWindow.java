package org.lilmoon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class ChatWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 500;
    private static final int WINDOW_POSY = 100;
    JPanel loginPanel = new JPanel(new GridLayout(1, 2));
    JLabel loginLabel = new JLabel("Введите логин: ");
    JTextField loginTextField = new JTextField();

    JPanel passwordPanel = new JPanel(new GridLayout(1, 2));
    JLabel passwordLabel = new JLabel("Введите пароль: ");
    JTextField passwordTextField = new JTextField();

    JPanel IPAdressPanel = new JPanel(new GridLayout(1, 2));
    JLabel IPAdressLabel = new JLabel("Введите IP адрес сервера: ");
    JTextField IPAdressTextField = new JTextField();

    JPanel portPanel = new JPanel(new GridLayout(1, 2));
    JLabel portLabel = new JLabel("Введите номер порта: ");
    JTextField portTextField = new JTextField();

    JButton btnLogin = new JButton("Подключиться");
    JTextArea textChat = new JTextArea();
    JScrollPane scrollPane = new JScrollPane(textChat);
    JPanel panelMain = new JPanel(new GridLayout(10, 1));

    JLabel jlb6 = new JLabel("Введите ваше сообщение: ");
    JTextArea chatMessage = new JTextArea();
    JButton pushMsg = new JButton("Отправить сообщение");

    String historyPath = "src/main/resources/chat.txt";
//    String logChat = "";
//    char[] bufferLog;

    public ChatWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("GB_chat");
        setResizable(true);
        setVisible(true);

        setLayout(new GridLayout(1, 1));
        loginPanel.add(loginLabel);
        loginPanel.add(loginTextField);
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordTextField);
        IPAdressPanel.add(IPAdressLabel);
        IPAdressPanel.add(IPAdressTextField);
        portPanel.add(portLabel);
        portPanel.add(portTextField);
        panelMain.add(loginPanel);
        panelMain.add(passwordPanel);
        panelMain.add(IPAdressPanel);
        panelMain.add(portPanel);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isHistoryExists()){
                    createHistoryFile();
                    loadMessages();
                }else loadMessages();
            }
        });
        pushMsg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }

        });

        chatMessage.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    pushMsg.doClick();
                }
            }
        });
        panelMain.add(btnLogin);
        textChat.setEditable(false);
        panelMain.add(scrollPane);

        panelMain.add(jlb6);
        panelMain.add(chatMessage);
        panelMain.add(pushMsg);
        add(panelMain);

    }

    private void sendMessage() {
        try (FileWriter writer = new FileWriter(historyPath)) {
            String message = chatMessage.getText();
            writer.append("\n");
            writer.append(message);

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        try (FileReader reader = new FileReader(historyPath)) {
            StringBuilder updatedMessage = new StringBuilder();
            int i;
            while ((i = reader.read()) != -1) {
                updatedMessage.append((char) i);
            }
            textChat.append(updatedMessage.toString());
            chatMessage.setText("");
            chatMessage.revalidate();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        JOptionPane.showMessageDialog(null, "Сообщение отправлено");
    }


    private boolean isHistoryExists(){
        return Files.notExists(Path.of(historyPath));
    }

    private void createHistoryFile(){
        try {
            File newFile = new File(historyPath);
            newFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void loadMessages() {
        try (FileReader fr = new FileReader(historyPath)){
            int b;
            while ((b = fr.read()) != -1) {
                textChat.append(Character.valueOf((char) b).toString());
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}