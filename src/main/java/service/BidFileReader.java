package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import model.BidWrap;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class BidFileReader {

    private static final Logger LOGGER = LoggerFactory.getLogger(BidFileReader.class);

    private static final String JSON_FILE = "bids.json";

    public static BidWrap[] readFile() {

        File file = new File(JSON_FILE);

        try {
            InputStream is = new FileInputStream(file);
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(is, BidWrap[].class);
        } catch (IOException e) {
            LOGGER.error("Error read or parse file: {}", e.getMessage(), e);
        }

        return null;
    }
}
