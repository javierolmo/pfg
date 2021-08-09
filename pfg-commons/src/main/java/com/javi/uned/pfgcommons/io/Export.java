package com.javi.uned.pfgcommons.io;

import com.javi.uned.pfgcommons.exceptions.ExportException;
import com.javi.uned.pfgcommons.model.MelodiaAbsolutePitch;
import com.javi.uned.pfgcommons.model.MelodiaScore;
import com.javi.uned.pfgcommons.model.measures.MelodiaMeasure;
import com.javi.uned.pfgcommons.model.parts.PartComposite;
import org.audiveris.proxymusic.*;
import org.audiveris.proxymusic.util.Marshalling;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.String;
import java.math.BigDecimal;
import java.util.List;

public class Export {

    private Export () {  }

    public static void toXML(MelodiaScore melodiaScore, File file) throws ExportException {
        try (FileOutputStream fos = new FileOutputStream(file)) {
            Marshalling.marshal(toScorePartwise(melodiaScore), fos, true, 4);
        } catch (IOException | Marshalling.MarshallingException e) {
            throw new ExportException("Error al exportar al archivo " + file.getAbsolutePath(), e);
        }
    }

    /**
     * Transformar en un objeto de la clase {@link ScorePartwise} para poder exportarlo a xml
     * @param melodiaScore partitura
     * @return {@link ScorePartwise} con la misma información
     */
    private static ScorePartwise toScorePartwise(MelodiaScore melodiaScore){
        ScorePartwise scorePartwise = new ScorePartwise();
        scorePartwise.setMovementTitle(melodiaScore.getMovementTitle());
        scorePartwise.setMovementNumber(melodiaScore.getMovementNumber());
        // scorePartwise.setVersion("1.0"); //TODO: Enterarme de como funciona esto
        scorePartwise.setDefaults(createDefaults());
        scorePartwise.setIdentification(createIdentification(melodiaScore.getAuthors()));
        scorePartwise.setWork(createWork(melodiaScore.getMovementTitle()));
        for(PartComposite partComposite : melodiaScore.getParts()){
            appendPart(scorePartwise, partComposite);
        }

        return scorePartwise;
    }

    private static Work createWork(String movementTitle){
        Work work = new Work();
        work.setWorkTitle(movementTitle);

        //TODO:
        //Work number
        //Opus

        return work;
    }

    private static Identification createIdentification(String[] authors){
        Identification identification = new Identification();

        //Creators:
        for(String author : authors){
            TypedText typedText = new TypedText();
            typedText.setType("composer");
            typedText.setValue(author);
            identification.getCreator().add(typedText);
        }

        //TODO:
        //Encoding
        //Miscellaneous
        //Relation
        //Rights
        //Source

        return identification;
    }

    private static Defaults createDefaults(){
        Defaults defaults = new Defaults();

        //TODO:
        //Appearence
        //Lyric Font
        //Lyric Languaje
        //Music font
        //Page layout
        //Scalling
        //Staff Layout
        //System layout
        //Word font

        return defaults;
    }

    private static void appendPart(ScorePartwise scorePartwise, PartComposite partComposite) {

        //Append part to partlist
        PartList partList = scorePartwise.getPartList();
        if (scorePartwise.getPartList() == null) {
            partList = new PartList();
        }
        ScorePart scorePart = new ScorePart();
        partList.getPartGroupOrScorePart().add(scorePart);
        PartName partName = new PartName();
        partName.setValue(partComposite.getPartName());
        scorePart.setPartName(partName);
        scorePart.setId(partComposite.getPartId());
        scorePartwise.setPartList(partList);
        scorePart.getScoreInstrument().add(partComposite.getInstrumento().toScoreInstrument());


        //Append part to parts
        List<ScorePartwise.Part> parts = scorePartwise.getPart();
        ScorePartwise.Part part = new ScorePartwise.Part();
        part.setId(scorePart);
        parts.add(part);

        //Append measures to part
        for (int i=0; i< partComposite.getMeasures().size(); i++) {
            MelodiaMeasure melodiaMeasure = partComposite.getMeasures().get(i);
            part.getMeasure().add(melodiaMeasure.toMeasure(i));
        }
    }

    public static Pitch transformPitch(MelodiaAbsolutePitch melodiaAbsolutePitch) {
        Pitch pitch = new Pitch();
        pitch.setStep(Step.valueOf(melodiaAbsolutePitch.getStep().getName()));
        pitch.setOctave(melodiaAbsolutePitch.getOctave());
        pitch.setAlter(BigDecimal.valueOf(melodiaAbsolutePitch.getAlter()));
        return pitch;
    }

}
