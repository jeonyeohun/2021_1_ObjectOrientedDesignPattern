import java.util.HashMap;
import java.util.Map;

public class PanelContainer {
    private Map<Integer, SolarPanel> map = new HashMap<Integer, SolarPanel>();
    public SolarPanel getPanel(int id) {
        SolarPanel panel = map.get(id);
        if (panel == null) {
            panel = new SolarPanel(id);
            map.put(id, panel);
        }
        return panel;
    }

}
