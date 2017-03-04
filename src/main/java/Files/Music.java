package Files;

import javax.sound.midi.*;

public class Music
{
    public static void main(String[] args)
    {
        Music start = new Music();
        start.play();
    }

    public void play()
    {
        try
        {
            Sequencer player = MidiSystem.getSequencer();
            player.open();

            Sequence sequence = new Sequence(Sequence.PPQ, 4);
            Track track = sequence.createTrack();

            ShortMessage first = new ShortMessage();
            first.setMessage(192, 1, 110, 0);
            MidiEvent chsngeInstument = new MidiEvent(first, 1);
            track.add(chsngeInstument);


            ShortMessage a = new ShortMessage();
            a.setMessage(144, 1, 102, 100);
            MidiEvent noteOn = new MidiEvent(a, 1);
            track.add(noteOn);

            ShortMessage b = new ShortMessage();
            a.setMessage(128, 1, 44, 100);
            MidiEvent noteOff = new MidiEvent(b, 3);
            track.add(noteOff);


            player.setSequence(sequence);
            player.start();

        }
        catch (Exception e)
        {
            System.out.println("Невдача!");
        }
    }
}
