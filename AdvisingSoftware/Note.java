package AdvisingSoftware;

import java.util.Date;

/**
 * Creates a note for the advisor
 * @author Garrett Spillman (@Spillmag), Lia Zhao (@zhaolia9), Stephon Johnson (@stephonj), Yasmine Kennedy (@yask8)
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
