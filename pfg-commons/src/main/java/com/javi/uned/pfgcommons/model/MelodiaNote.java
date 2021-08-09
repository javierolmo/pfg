package com.javi.uned.pfgcommons.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.javi.uned.pfgcommons.io.Export;
import com.javi.uned.pfgcommons.model.constants.Figuras;
import com.javi.uned.pfgcommons.model.constants.MelodiaAbsolutePitches;
import org.audiveris.proxymusic.Note;
import org.audiveris.proxymusic.NoteType;
import org.audiveris.proxymusic.TimeModification;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;
import java.util.Random;

public class MelodiaNote {

    private MelodiaAbsolutePitch pitch;
    private Figura figura;
    private TimeModification timeModification;

    public MelodiaNote(){

    }

    public MelodiaNote(MelodiaAbsolutePitch pitch, Figura figura) {
        this.figura = figura;
        this.pitch = pitch;
    }

    public MelodiaAbsolutePitch getPitch() {
        return pitch;
    }

    public void setPitch(MelodiaAbsolutePitch pitch) {
        this.pitch = pitch;
    }

    public Figura getFigura() {
        return figura;
    }

    public void setFigura(Figura figura) {
        this.figura = figura;
    }

    public TimeModification getTimeModification() {
        return timeModification;
    }

    public void setTimeModification(TimeModification timeModification) {
        this.timeModification = timeModification;
    }

    @JsonIgnore
    public int estimateDuration(int quarterDivisions){
        double result = getFigura().getDuration() * quarterDivisions;
        return (int) result;
    }

    @JsonIgnore
    public Note toNote(int quarterDivisions, int staff){
        Note note = new Note();

        //Pitch
        note.setPitch(Export.transformPitch(this.pitch));

        //Duration
        note.setDuration(BigDecimal.valueOf(estimateDuration(quarterDivisions)));

        //Value
        NoteType noteType = new NoteType();
        noteType.setValue(figura.getType());
        note.setType(noteType);

        //Staff
        note.setStaff(BigInteger.valueOf(staff+1));

        //Voice
        note.setVoice(""+staff);

        //Time modification
        if(timeModification != null) {
            note.setTimeModification(timeModification);
        }
        return note;
    }

    @JsonIgnore
    public int comparePitch(MelodiaNote note2){
        return this.pitch.compareTo(note2.pitch);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MelodiaNote that = (MelodiaNote) o;
        return Objects.equals(pitch, that.pitch) && Objects.equals(figura, that.figura) && Objects.equals(timeModification, that.timeModification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pitch, figura, timeModification);
    }

    public static MelodiaNote random (
            Figura minDuration, Figura maxDuration, MelodiaAbsolutePitch minPitch, MelodiaAbsolutePitch maxPitch) {

        return new MelodiaNote(
                MelodiaAbsolutePitches.randomPitch(minPitch, maxPitch, new Random().nextBoolean()),
                Figuras.random(minDuration, maxDuration));

    }

    @Override
    public String toString() {
        return "NoteComposite{" +
                "pitch=" + pitch +
                ", figura=" + figura +
                ", timeModification=" + timeModification +
                '}';
    }
}
