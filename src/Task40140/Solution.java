package Task40140;

import Task40140.controller.Controller;
import Task40140.model.MainModel;
import Task40140.model.Model;
import Task40140.view.EditUserView;
import Task40140.view.UsersView;

public class Solution {
    public static void main(String[] args) {
        Model model = new MainModel();
        UsersView usersView = new UsersView();
        EditUserView editUserView = new EditUserView();
        Controller controller = new Controller();

        usersView.setController(controller);
        editUserView.setController(controller);
        controller.setModel(model);
        controller.setUsersView(usersView);
        controller.setEditUserView(editUserView);

        usersView.fireEventShowAllUsers();
        usersView.fireEventOpenUserEditForm(126L);
        editUserView.fireEventUserDeleted(124L);
        editUserView.fireEventUserChanged("Eremenko", 125L, 3);
        usersView.fireEventShowDeletedUsers();
    }
}