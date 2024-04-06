package org.lilmoon;

import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Logger;

/*
Создать простейшее окно управления сервером (по сути, любым), содержащее две кнопки (JButton) - запустить сервер
 и остановить сервер.
 Кнопки должны просто логировать нажатия (имитировать запуск и остановку сервера, соответственно) и
 выставлять внутри интерфейса соответствующее булево isServerWorking.
 */

public class ServerRun extends JFrame {
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;

    JButton btnStart = new JButton("Start server");
    JButton btnStop = new JButton("Stop server");
    boolean isServerWorking;


    ServerRun() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("ServerRun");
        setResizable(false);


        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                isServerWorking = true;
                showStatus();
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                isServerWorking = false;
                showStatus();
            }
        });
        setLayout(new GridLayout(1, 2));
        add(btnStart);
        add(btnStop);
        setVisible(true);
    }

    public void showStatus() {
        String msg = "Статус сервера: " + (isServerWorking ? " запущен" : " остановлен.");
        System.out.println(msg);
        Logger logger = Logger.getLogger("logger");
        logger.info(msg);
    }
}
