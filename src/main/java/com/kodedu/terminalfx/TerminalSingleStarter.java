package com.kodedu.terminalfx;

import com.kodedu.terminalfx.config.TerminalConfig;
import com.kodedu.terminalfx.helper.ThreadHelper;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class TerminalSingleStarter extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        TerminalConfig config = new TerminalConfig();

        Terminal terminal = new Terminal(config,null);

        Scene scene = new Scene(terminal);
        stage.setTitle("TerminalFX");
        stage.setScene(scene);
        stage.show();

        terminal.onTerminalFxReady(() -> {
            terminal.command("dir\r");
            terminal.command("wt\r");
        });

    }

    @Override
    public void stop() throws Exception {
        ThreadHelper.stopExecutorService();
        Platform.exit();
        System.exit(0);
    }

}
