package cvut.fit.matsnnik.hospital.api.dtos;

public class DoctorLoginDTO
{
    private int did;
    private String password;

    public DoctorLoginDTO(int did, String password) {
        this.did = did;
        this.password = password;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
