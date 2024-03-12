package com.bridgelabz.notesapplication.note.dto;

public class NoteDTO {
    private String title;
    private String description;
    private String color;
    private boolean isPinned;
    private boolean isArchived;
    private boolean isTrashed;
    private String reminder;
    private int userId;
    private int noteId;
    private int labelId;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getColor() {
        return color;
    }

    public boolean isPinned() {
        return isPinned;
    }

    public boolean isArchived() {
        return isArchived;
    }

    public boolean isTrashed() {
        return isTrashed;
    }

    public String getReminder() {
        return reminder;
    }

    public int getUserId() {
        return userId;
    }

    public int getNoteId() {
        return noteId;
    }

    public int getLabelId() {
        return labelId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPinned(boolean pinned) {
        isPinned = pinned;
    }

    public void setArchived(boolean archived) {
        isArchived = archived;
    }

    public void setTrashed(boolean trashed) {
        isTrashed = trashed;
    }

    public void setReminder(String reminder) {
        this.reminder = reminder;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public void setLabelId(int labelId) {
        this.labelId = labelId;
    }
}
