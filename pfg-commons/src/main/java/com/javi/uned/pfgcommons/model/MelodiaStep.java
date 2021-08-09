package com.javi.uned.pfgcommons.model;

import com.javi.uned.pfgcommons.model.constants.MelodiaSteps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class MelodiaStep {

    private static final Logger logger = LoggerFactory.getLogger(MelodiaStep.class);

    private final String name;
    private final int semitones;

    public MelodiaStep(String name, int semitones) {
        this.name = name;
        this.semitones = semitones;
    }

    public String getName() {
        return name;
    }

    public int getSemitones() {
        return semitones;
    }

    public static MelodiaStep of(int semitones, boolean preferSharps) {
        switch (semitones) {
            case 0: return MelodiaSteps.C;
            case 1: return preferSharps? MelodiaSteps.C : MelodiaSteps.D;
            case 2: return MelodiaSteps.D;
            case 3: return preferSharps? MelodiaSteps.D : MelodiaSteps.E;
            case 4: return MelodiaSteps.E;
            case 5: return MelodiaSteps.F;
            case 6: return preferSharps? MelodiaSteps.F : MelodiaSteps.G;
            case 7: return MelodiaSteps.G;
            case 8: return preferSharps? MelodiaSteps.G : MelodiaSteps.A;
            case 9: return MelodiaSteps.A;
            case 10: return preferSharps? MelodiaSteps.A : MelodiaSteps.B;
            case 11: return MelodiaSteps.B;
            default:
                logger.error("No se ha podido crear un 'Step' a partir del número de semitonos y la preferencia de alteraciones: MelodiaStep.of(int, bool)");
                return null;
        }
    }

    public String getTraditionalName() {
        switch (name) {
            case "A": return "La";
            case "B": return "Si";
            case "C": return "Do";
            case "D": return "Re";
            case "E": return "Mi";
            case "F": return "Fa";
            case "G": return "Sol";
            default:
                logger.error("Error al parsear nombre de nota: {}", name);
                return "Error";
        }
    }

    public MelodiaStep interval(int distance, boolean ascendent) {
        return MelodiaSteps.interval(this, distance, ascendent);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MelodiaStep that = (MelodiaStep) o;
        return semitones == that.semitones && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, semitones);
    }

    @Override
    public String toString() {
        return name;
    }
}
