package com.example.crypto;

import com.example.crypto.request.HttpUrlConnection;

import java.io.IOException;
import java.net.MalformedURLException;

public class DemoUrlConnection {
    public static void main(String[] args) {
        try {
            HttpUrlConnection connection = new HttpUrlConnection();
            connection.init();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
