package no.oslomet.cs.algdat.Oblig3;


import java.util.*;

public class SBinTre<T> {
    private static final class Node<T>   // en indre nodeklasse
    {
        private T verdi;                   // nodens verdi
        private Node<T> venstre, høyre;    // venstre og høyre barn
        private Node<T> forelder;          // forelder

        // konstruktør
        private Node(T verdi, Node<T> v, Node<T> h, Node<T> forelder) {
            this.verdi = verdi;
            venstre = v;
            høyre = h;
            this.forelder = forelder;
        }

        private Node(T verdi, Node<T> forelder)  // konstruktør
        {
            this(verdi, null, null, forelder);
        }

        @Override
        public String toString() {
            return "" + verdi;
        }

    } // class Node

    private Node<T> rot;                            // peker til rotnoden
    private int antall;                             // antall noder
    private int endringer;                          // antall endringer

    private final Comparator<? super T> comp;       // komparator

    public SBinTre(Comparator<? super T> c)    // konstruktør
    {
        rot = null;
        antall = 0;
        comp = c;
    }

    public boolean inneholder(T verdi) {
        if (verdi == null) return false;

        Node<T> p = rot;

        while (p != null) {
            int cmp = comp.compare(verdi, p.verdi);
            if (cmp < 0) p = p.venstre;
            else if (cmp > 0) p = p.høyre;
            else return true;
        }

        return false;
    }

    public int antall() {
        return antall;
    }

    public String toStringPostOrder() {
        if (tom()) return "[]";

        StringJoiner s = new StringJoiner(", ", "[", "]");

        Node<T> p = førstePostorden(rot); // går til den første i postorden
        while (p != null) {
            s.add(p.verdi.toString());
            p = nestePostorden(p);
        }

        return s.toString();
    }

    public boolean tom() {
        return antall == 0;
    }

    public boolean leggInn(T verdi)  {

        // Programkode 5.2.3A brukt
        Objects.requireNonNull(verdi, "Ulovlig med nullverdier!");

        Node<T> p = rot, q = null;
        int cmp = 0;

        while (p != null)
        {
            q = p;
            cmp = comp.compare(verdi,p.verdi);
            p = cmp < 0 ? p.venstre : p.høyre;
        }

        p = new Node<>(verdi,q);

        if (q == null) rot = p;
        else if (cmp < 0) q.venstre = p;
        else q.høyre = p;

        antall++;
        endringer++;
        return true;
    }

    public boolean fjern(T verdi) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public int fjernAlle(T verdi) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public int antall(T verdi) {
        Node<T> p = rot; //node
        int verdier = 0; // antall forekomster av verdi
        while(p != null)
        {
            int compare = comp.compare(verdi,p.verdi); //sammenlikner verdi og p.verdi og returnerer 0 hvis verdi=p.verdi -1 hvis veri<p.verdi 1 hvis omvendt
            if(compare <0)
                p = p.venstre;
            else{
                if(compare ==0)
                    verdier++; // legger på antall forekomster av verdi
                p=p.høyre;
            }
        }
        return verdier;
    }

    public void nullstill() {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    private static <T> Node<T> førstePostorden(Node<T> p) {
            while (true)
            {
                if (p.venstre != null) p = p.venstre;
                else if (p.høyre != null) p = p.høyre;
                else return p;

        }
    }

    private static <T> Node<T> nestePostorden(Node<T> p) {
        if (p.forelder == null) { //rot noden
            return null;
        }
        if(p.forelder.høyre == null){ // ser om det finnes et høyre barn
            return p.forelder;
        }
        else if(p.forelder.høyre == p){ // sjekker om det er høyrebarn
            return p.forelder;
        }
        else{
            return førstePostorden(p.forelder.høyre);
        }
    }



    public void postorden(Oppgave<? super T> oppgave) {
        if(rot == null) return; // treet er tomt
        Node<T> p = rot;
        p = førstePostorden(p); // første i postorden
        while(p != null){
            oppgave.utførOppgave(p.verdi);
            p = nestePostorden(p); // bruker nestePostorden i en while løkke
        }
    }

    public void postordenRecursive(Oppgave<? super T> oppgave) {
        postordenRecursive(rot, oppgave);
    }

    private void postordenRecursive(Node<T> p, Oppgave<? super T> oppgave) {
        if (p.venstre != null) // traverserer i postorden rekkefølge venstre->høyre->rot
            postordenRecursive(p.venstre,oppgave); // kaller seg selv (rekursiv metode)
        if (p.høyre != null)
            postordenRecursive(p.høyre,oppgave);
        oppgave.utførOppgave(p.verdi);
    }
    public ArrayList<T> serialize() {
        if(tom()) return null;
        Queue <Node<T>> kø = new LinkedList<>(); // kø system
        ArrayList<T> list = new ArrayList<>(); // lager en arraylist
        kø.add(rot);
        while(!kø.isEmpty()) {
            Node<T> p = kø.poll(); // kø.poll returnerer og fjerner element på fronten av containeren
            list.add(p.verdi);

            if (p.venstre != null)kø.add(p.venstre); // hvis p.venstre ikke er null så legger vi til p.venstre i køen
            if(p.høyre!=null)kø.add(p.høyre);

        }
        return list;
    }

    static <K> SBinTre<K> deserialize(ArrayList<K> data, Comparator<? super K> c) {
        // ta arrayet og legge inn alle verdiene i nivåå orden og gjenskape binærtreet
    }


} // ObligSBinTre
