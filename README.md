# Obligatorisk oppgave 3 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende student:
* Sander Sævik, s362067, s362067@oslomet.no


# Oppgavebeskrivelse

I oppgave 1 så gikk jeg frem ved å bruke programkoden som var oppgitt i oppgaven. Måtte legge til to ting, en ting i new Node<> og å legge til endringer++.

I oppgave 2 så lagde jeg metoden int antall(T verdi). Her skulle man lage en metode som returnerer antall forekomster av verdier i treet. Starta med å lage Node<T> p = rot; og lage en variabel verdier. Så lagde jeg en while løkke hvor den går til p er 0. Så brukte jeg compare til å compare verdi og p.verdi, og ut ifra det la jeg til antall forekomster av verdi og returnerte det. 

I oppgave 3 lagde jeg hjelpemetodene førstePostorden og nestePostorden. Her skal jeg først lage en metode som finner første node postorden i treet, og nestepostorden skal jeg returnere noden som kommer etter p. Første postorden skal man finne noden som er lengst til venstre i treet, og da bare lagde jeg en while statement og fant den. I nestepostorden så sjekker jeg om det finnes et høyre barn og etter om noden er et høyrebarn, og videre returnerer førstepostorden(p.forelder.høyre).

I oppgave 4 lagde jeg hjelpemetodene postorden og postordenRecursive. I postorden måtte vi bruke nestepostorden. Her satte jeg når p ikke er null så vil oppgave utføres og p = nestePostorden(p); I postordenRecursive skulle jeg lage en metode som som har et rekursivt kall og traverserer treet i postorden rekkefølge venstre-høyre-rot. Starter med venstre så hæyre også til slutt går den til rot. Brukte if setninger her og satte først hvis p.venstre ikke = 0 så kaller den postordenRecursive, deretter hvis p.høyre ikke = 0, så kaller vi postordenRecursive også utfør oppgave. 

I oppgave 5 lagde jeg metodene serialize og deserialize. I metoden serialize skulle vi gjøre om binæretreet til et array, og i deserialize gjøre om et array til binær søketre. I serialize oppgaven måtte vi bruke en kø. Startet med å sette opp et køsystem, også en array list. Deretter brukte jeg en while statement til å få satte inn alt i køen og listen. I deserialize oppgaven, så var det ikke så mye å gjøre, bare bruke en for each loop og legginn til å plotte verdiene inn i det binære søketreet.

Oppgave 6 ble jeg ikke helt ferdig med, men fikk starta. Lagde fjern metoden, ved å kopiere programkoden som var oppgitt i oppgaven. I fjernalle metoden lagde jeg først en variabel for forekomstene av verdi, så brukte jeg fjern metoden vi lagde tidligere i oppgaven i en whilestatement og øker verdiforekomst samtidig. I nullstill oppgaven prøvde jeg å brukte en while statement helt til treet er tomt, og bare traversere gjennom for å nullstille.


