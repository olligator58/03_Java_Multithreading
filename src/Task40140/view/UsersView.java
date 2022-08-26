package Task40140.view;

import Task40140.bean.User;
import Task40140.controller.Controller;
import Task40140.model.ModelData;

import java.util.List;

public class UsersView implements View {
    private Controller controller;

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void refresh(ModelData modelData) {
        List<User> users = modelData.getUsers();
        String deleted = (modelData.isDisplayDeletedUserList()) ? " deleted" : "";
        System.out.println(String.format("All%s users:", deleted));
        for (User user : users) {
            System.out.println("\t" + user);
        }
        System.out.println("===================================================");
    }

    public void fireEventShowAllUsers() {
        controller.onShowAllUsers();
    }

    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }

    public void fireEventOpenUserEditForm(long id) {
        controller.onOpenUserEditForm(id);
    }

}
