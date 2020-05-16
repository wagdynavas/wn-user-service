package wagdynavas.com.wnuserservice.entities;

public class Summoner {

    private String accountid;
    private int profileIconId;
    private String name;
    private String id;
    private String sumonerLevel;


    public Summoner() {
    }

    public String getAccountid() {
        return accountid;
    }

    public void setAccountid(String accountid) {
        this.accountid = accountid;
    }

    public int getProfileIconId() {
        return profileIconId;
    }

    public void setProfileIconId(int profileIconId) {
        this.profileIconId = profileIconId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSumonerLevel() {
        return sumonerLevel;
    }

    public void setSumonerLevel(String sumonerLevel) {
        this.sumonerLevel = sumonerLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Summoner summoner = (Summoner) o;

        if (profileIconId != summoner.profileIconId) return false;
        if (accountid != null ? !accountid.equals(summoner.accountid) : summoner.accountid != null) return false;
        if (name != null ? !name.equals(summoner.name) : summoner.name != null) return false;
        if (id != null ? !id.equals(summoner.id) : summoner.id != null) return false;
        return sumonerLevel != null ? sumonerLevel.equals(summoner.sumonerLevel) : summoner.sumonerLevel == null;
    }

    @Override
    public int hashCode() {
        int result = accountid != null ? accountid.hashCode() : 0;
        result = 31 * result + profileIconId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (sumonerLevel != null ? sumonerLevel.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Summoner{" +
                "accountid='" + accountid + '\'' +
                ", profileIconId=" + profileIconId +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", sumonerLevel='" + sumonerLevel + '\'' +
                '}';
    }
}
