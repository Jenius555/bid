package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.BidWrap;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class BidFileReader {

    public static BidWrap[] readFile() {

        File file = new File("bids.json");

        try {
            InputStream is = new FileInputStream(file);
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(is, BidWrap[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
