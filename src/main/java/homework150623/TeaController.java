package homework150623;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TeaController {

    private List<Tea> teas = new ArrayList<>();

    private TeaController() {
        teas.addAll(
                List.of(new Tea("Sencha"),
                        new Tea("Assam"),
                        new Tea("Ceylon"))
        );
    }

    @GetMapping("/teaslist")
    public Iterable<Tea> getTeas() {
        return teas;
    }

    @PostMapping("/teaslist/tea")
    public Tea createCoffees(@RequestBody Tea tea) {
        teas.add(tea);
        return tea;
    }

    @DeleteMapping("/teaslist/(uuid)")
    public void deleteTea(@PathVariable String uuid) {
        teas.removeIf(tea -> tea.getUuid().equals(uuid));
    }

    @PutMapping("/teaslist/(uuid)")
    public Tea putTea(@PathVariable String uuid, @RequestBody Tea tea) {
        for (Tea c : teas) {
            if (c.getUuid().equals(uuid)) {
                c.setName(tea.getName());
                return c;
            }
        }
        return null;
    }
}
