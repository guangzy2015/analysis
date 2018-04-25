package com.feng.analysis.common.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class FileUtil {
    private FileUtil() {
    }

    public static List<String> readFile(String fileName) {
        List<String> contentList = new ArrayList<String>();
        FileInputStream inputStream = null;
        BufferedReader bufferedReader = null;
        try {
            inputStream = new FileInputStream(fileName);
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String str;
            while ((str = bufferedReader.readLine()) != null ) {
                contentList.add(str);
            }
        } catch (Exception e) {
            log.error("Read file got exception.", e);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                log.warn("Close io got exception.", e);
            }
        }
        return contentList;
    }
}
