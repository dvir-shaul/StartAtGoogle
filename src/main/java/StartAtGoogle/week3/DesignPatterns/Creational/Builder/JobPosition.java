package StartAtGoogle.week3.DesignPatterns.Creational.Builder;

import java.time.LocalDate;

public class JobPosition {
    private final LocalDate PublishedDate;
    private final String title;
    private String Description;
    private String Location;
    private double salaryCap;
    private final boolean isRemote;
    private int yearsOfExperienceReq;

    public static class Builder {
        private final LocalDate PublishedDate;
        private final String title;
        private final boolean isRemote;

        // optional
        private String Description;
        private String Location = "Tel Aviv";
        private double salaryCap;
        private int yearsOfExperienceReq;

        public Builder(LocalDate date, String title, boolean isRemote) {
            this.PublishedDate = date;
            this.title = title;
            this.isRemote = isRemote;
        }

        public Builder Description(String desc) {
            this.Description = desc;
            return this;
        }

        public Builder salaryCap(double salary) {
            this.salaryCap = salary;
            return this;
        }

        public Builder yearsOfExperienceReq(int yoer) {
            this.yearsOfExperienceReq = yoer;
            return this;
        }

        public JobPosition build() {
            return new JobPosition(this);
        }
    }

    private JobPosition(Builder builder) {
        this.PublishedDate = builder.PublishedDate;
        this.Description = builder.Description;
        this.title = builder.title;
        this.isRemote = builder.isRemote;
        this.Location = builder.Location;
        this.salaryCap = builder.salaryCap;
        this.yearsOfExperienceReq = builder.yearsOfExperienceReq;
    }

    @Override
    public String toString() {
        return "JobPosition{" +
                "PublishedDate=" + PublishedDate +
                ", title='" + title + '\'' +
                ", Description='" + Description + '\'' +
                ", Location='" + Location + '\'' +
                ", salaryCap=" + salaryCap +
                ", isRemote=" + isRemote +
                ", yearsOfExperienceReq=" + yearsOfExperienceReq +
                '}';
    }
}
