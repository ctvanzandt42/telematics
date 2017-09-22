import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TelematicsService {

    void report(VehicleInfo vehicleInfo) {
        // 1. create one JSON string for vehicle and output to a .json file
        writeJsonFile(vehicleInfo);

        // 2.
        convertJson(vehicleInfo);

    }

    private void writeJsonFile(VehicleInfo vehicleInfo) {
        try {
            File outputFile = new File(Integer.toString(vehicleInfo.getVIN()) + ".json");
            FileWriter fileWriter = new FileWriter(outputFile);

            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(vehicleInfo);

            fileWriter.write(json);
            fileWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void convertJson(VehicleInfo vehicleInfo) {
        // for each JSON file:
        //    build a new Vehicle obj
        //    create a new TR line for each Vehicle's info (template engine fake)
        File file = new File(".");
        String midHTML = "<html>\n" +
                "  <title>Vehicle Telematics Dashboard</title>\n" +
                "  <body>\n" +
                "    <h1 align=\"center\">Averages for # vehicles</h1>\n" +
                "    <table align=\"center\">\n" +
                "        <tr>\n" +
                "            <th>Odometer (miles) |</th><th>Consumption (gallons) |</th><th>Last Oil Change |</th><th>Engine Size (liters)</th>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td align=\"center\">#</td><td align=\"center\">#</td><td align=\"center\">#</td align=\"center\"><td align=\"center\">#</td>\n" +
                "        </tr>\n" +
                "    </table>\n" +
                "    <h1 align=\"center\">History</h1>\n" +
                "    <table align=\"center\" border=\"1\">\n" +
                "        <tr>\n" +
                "            <th>VIN</th><th>Odometer (miles)</th><th>Consumption (gallons)</th><th>Last Oil Change</th><th>Engine Size (liters)</th>\n" +
                "        </tr>";
        for (File f : file.listFiles()) {
            if (f.getName().endsWith(".json")) {

                ObjectMapper mapper = new ObjectMapper();
                VehicleInfo vi = null;
                try {
                    vi = mapper.readValue(f, VehicleInfo.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                 midHTML += "<tr>\n" +
                        "            <td align=\"center\">#VIN</td><td align=\"center\">#Odometer</td><td align=\"center\">#Consumption</td><td align=\"center\">#LastOilChange</td align=\"center\"><td align=\"center\">#Enginesize</td>\n" +
                        "        </tr>";

                midHTML = midHTML.replaceAll("#VIN", Integer.toString(vi.getVIN()));
                midHTML = midHTML.replaceAll("#Odometer", Double.toString(vi.getOdometer()));
                midHTML = midHTML.replaceAll("#Consumption", Double.toString(vi.getConsumption()));
                midHTML = midHTML.replaceAll("#LastOilChange", Double.toString(vi.getOdometerLastOilChange()));
                midHTML = midHTML.replaceAll("#Enginesize", Double.toString(vi.getEngineSize()));

                midHTML += "</table>\n" +
                        "  </body>\n" +
                        "</html>";
            }

        }
    }
}

