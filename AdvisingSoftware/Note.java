package AdvisingSoftware;

import java.util.Date;

/**
 * Holds the notes from the advisor
 * 
 * @author yask8(Yasmine Kennedy) and Spillmag(Garrett Spillman)
 */
public class Note {

  private String note;
  private Date date;

  public Note(String note, Date date) {
    this.note = note;
    this.date = date;
  }

  public String getNote() {
    return note;
  }

  public Date getDate() {
    return date;
  }

  public String toString() {
    return "Note: " + note + "\tDate: " + date;
  }
}
