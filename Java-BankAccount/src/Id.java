public class Id {
    private String id;

    public Id(String id){
        setId(id);
    }

    private void setId(String id){
        if (id.length()!=8){
            throw new IllegalArgumentException("Invalid ID!");
        }
        this.id = id;
    }
}
