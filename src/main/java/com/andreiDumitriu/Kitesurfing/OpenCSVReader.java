package com.andreiDumitriu.Kitesurfing;

import com.opencsv.CSVReader;
import lombok.Data;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Data
class OpenCSVreader {

    String fileName;

    OpenCSVreader(String fileName){
        this.fileName=fileName;
    }


    public List<String> read() throws IOException{

        try(
                Reader reader = Files.newBufferedReader(Paths.get(fileName));
                CSVReader csvReader = new CSVReader(reader,';');

                )
        {

                String [] nextRecord;
                nextRecord=csvReader.readNext();
                List<String> locationList = new ArrayList<>();
                int i=0;
                while((nextRecord=csvReader.readNext())!=null){
                    locationList.add(nextRecord[0]);
                    locationList.add(nextRecord[1]);
                    locationList.add(nextRecord[2]);
                    locationList.add(nextRecord[3]);
                    locationList.add(nextRecord[4]);
                    locationList.add(nextRecord[5]);

                }

            return locationList;
        }


    }


}
