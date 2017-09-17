import java.io.File;
import java.io.FileWriter;

public class TelematicsService {

    void report (VehicleInfo vehicleInfo) {
        try {
            File file = new File(vehicleInfo.getVIN() + ".json");
            FileWriter fileWriter = new FileWriter(file);


        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}