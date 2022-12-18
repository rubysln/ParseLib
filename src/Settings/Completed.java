package Settings;

public class Completed implements OnCompleted {

    @Override
    public void onCompleted(Object sender) {
        System.out.println("Загрузка завершена!");
    }
}
