package AdvisingSoftware;

import java.util.Date;

public class Note {

  private String note;
  private Date date;

  public Note(String note, Date date) {
    this.note = note;
    this.date = date;
  }

  public String toString() {
    return "Note: " + note + "\tDate: " + date;
  }
}
