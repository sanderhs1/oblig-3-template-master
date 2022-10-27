# Obligatorisk oppgave 3 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende student:
* Sander Sævik, s362067, s362067@oslomet.no


# Oppgavebeskrivelse

I oppgave 1 så gikk jeg frem ved å bruke programkoden som var oppgitt i oppgaven. Måtte legge til to ting, en ting i new Node<> og å legge til endringer++.

I oppgave 2 så lagde jeg metoden int antall(T verdi). Her skulle man lage en metode som returnerer antall forekomster av verdier i treet. Starta med å lage Node<T> p = rot; og lage en variabel verdier. Så lagde jeg en while løkke hvor den går til p er 0. Så brukte jeg compare til å compare verdi og p.verdi, og ut ifra det la jeg til antall forekomster av verdi og returnerte det. 

I oppgave 3 lagde jeg hjelpemetodene førstePostorden og nestePostorden. Her skal jeg først lage en metode som finner første node postorden i treet, og nestepostorden skal jeg returnere noden som kommer etter p. Første postorden skal man finne noden som er lengst til venstre i treet, og da bare lagde jeg en while statement og fant den. I nestepostorden så sjekker jeg om det finnes et høyre barn og etter om noden er et høyrebarn, og videre returnerer førstepostorden(p.forelder.høyre).

I oppgave 4 lagde jeg hjelpemetodene postorden og postordenRecursive. 
