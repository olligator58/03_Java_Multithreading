package Task40140.view;

import Task40140.controller.Controller;
import Task40140.model.ModelData;

public interface View {
    void refresh(ModelData modelData);
    void setController(Controller controller);
}
