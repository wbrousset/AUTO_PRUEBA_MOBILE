package com.igs.utils;

import com.igs.managers.MobileDriverManager;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class testandoword {
    public static void main(String[] args) throws IOException {
        WordDocument document = new WordDocument();
        String aleatorio = "";

        File imagen = new File("C:\\Users\\elias\\IdeaProjects\\com.igs\\src\\test\\resources\\templates\\baufest.png");
        byte[] screenshot = IOUtils.toByteArray(new FileInputStream(imagen));

        for (int i = 0; i < 20; i++) {
            if ((i % 3) == 0) {
                aleatorio = "PASSED";
            }

            if ((i % 4) == 0) {
                aleatorio = "FAILED";
            }

            if ((i % 7) == 0) {
                aleatorio = "SKIPPED";
            }

            if ((i % 11) == 0) {
                aleatorio = "PENDING";
            }

            if ((i % 13) == 0) {
                aleatorio = "UNDEFINED";
            }

            document.addNewScenario("COCO " + i, aleatorio, screenshot);
        }
    }
}
