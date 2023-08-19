# Corso di Ingegneria del Software a.a. 2017/18

## Laboratorio 3

Ogni coppia di studenti procede ad effettuare il **fork** di questo repository.
Inoltre, concede i permessi di scrittura al proprio compagno di team e i **permessi di lettura** ai due docenti (`carlobellettini` e `matteocamilli`).

Una volta effettuato il **clone** del repository, il **driver** effettua `cd` nella directory del progetto ed esegue il comando:

```
bash start.sh email_unimi  username_bitbucket username_bitbucket_compagno
```

- controllare con il nuovo comando `git pair` che gli username siano corretti
- ogni volta che si cambia chi ha la tastiera (normalmente dopo aver fatto passare un nuovo test),
  dare il comando `git pair swap` e controllare con `git pair` che l'ordine delle username sia corretto

## Processo

![enter image description here](https://www.ciao-brussels.com/wp-content/uploads/2022/02/Ciao4-1-uai-2064x731.png)

Una volta effettuato il **clone** del repository, il gruppo esegue il comando `git flow init` all'interno della directory clonata.
Dopodiché, il gruppo implementa secondo la *metodologia TDD*
le specifiche riportate di seguito; in maggior dettaglio, ripete i passi seguenti fino ad aver implementato tutte le funzionalità richieste:

* crea un nuovo *branch* per la funzionalità corrente attraverso l'esecuzione del comando `git flow feature start`,
* implementa un test per le funzionalità richieste **procedendo nell'ordine** in cui sono specificate,
* verifica che **il codice compili correttamente**, ma l'**esecuzione del test fallisca**; solo a questo punto effettua un *commit* (usando `git add` e `git commit`) iniziando il messaggio di commit con la stringa `ROSSO:`,
* aggiunge la minima implementazione necessaria a realizzare la funzionalità, in modo che **il test esegua con successo**; solo a questo punto
  effettua un *commit* (usando `git add` e `git commit`) iniziando il messaggio di commit con la stringa `VERDE:`,
* procede, se necessario, al **refactoring** del codice, accertandosi che le modifiche non comportino il fallimento di alcun test; solo in questo caso fa seguire ad ogni
  passo un *commit* (usando `git add` e `git commit`) iniziando il messaggio di commit con la stringa `REFACTORING:`,
* esegue il *merge* del *branch* per la funzionalità sviluppata all'interno del *branch develop* attraverso il comando `git flow feature finish`,
* **solo in fase di rilascio**, esegue una *release* all'interno del *branch master* attraverso il comando `git flow release start` e successivamente `git flow release finish`,
* effettua un *push* (di tutti i *branch*) su Bitbucket con `git push origin --all --follow-tags`.

Al termine del laboratorio effettua un **ultima release**, un ultimo *push*, e **verifica su Bitbucket** che ci sia la completa traccia di *commit* effettuati.
Si suggerisce di eseguire i test non soltanto con Eclipse, ma anche eseguendo `./gradlew build` da riga di comando.


## Specifica dei requisiti

![enter image description here](https://it.wikipedia.org/wiki/Addizione#/media/File:AdditionLineUnary.svg)

Le funzionalità di seguito elencate vanno implementate **nell'ordine in cui
sono presentate**. Si suggerisce  di prendere visione di una funzionalità per
volta (procedendo subito al ciclo di implementazione della medesima) in modo
da non farsi influenzare dalle specifiche successive circa le scelte di
progetto.

Obiettivo dell'esercizio è creare una semplice "calcolatrice" che implementi
l'interfaccia `Calculator` che dichiara il metodo:

```java
int add(String expression)
```

Il comportamento che tale metodo deve esibire è specificato dai seguenti punti:

* prendere in input 0, 1 o 2 interi separati da virgola, e restituire
   la loro somma (per convenzione, 0 numeri, ossia la stringa vuota, ha somma 0)

```java
add("") restituisce 0
add("1") restituisce 1
add("1,2") restituisce 3
```

* prendere in input un *numero arbitrario* di interi, separati da virgola, e restituirne la somma;

* gestire il caso in cui i numeri siano separati da *a-capo*, oltre che da virgola,

```java
add("1\n2,3") restituisce 6
```

* consentire anche la definizione di un *diverso separatore* come prima linea dell'input, secondo la seguente sintassi:

```java
//char\nexpression
```

ad esempio:

```java
add("//;\n1;2") restituisce 3
add("//;\n1;2,3\n10") restituisce 16
```
si osservi che la presenza della definizione del separatore è opzionale, ossia restano validi i separatori virgola e a-capo.

Le funzionalità fino ad ora sviluppate rappresentano la **prima release** del software che deve essere etichettata come `versione 1.0`.

* sollevare una eccezione di tipo `IllegalArgumentException` con messaggio `"Numeri negativi non ammessi: "` seguito da tutti i *numeri negativi* eventualmente
  presenti nella lista, ad esempio

```java
add("-1,3,-2") solleva l'eccezione con messaggio "Numeri negativi non ammessi: -1, -2"
```

* ignorare *numeri superiori a 1000*, ad esempio:

```java
add("1001,2") restituisce 2
```

* consentire anche la definizione di un *separatore multi-carattere* come prima linea dell'input, secondo la seguente sintassi:

```java
"//[delimiter]\n"
```
ad esempio

```java
add("//[***]\n1***2***3") restituisce 6
```

* consentire anche la definizione di due, o più, *separatori multi-carattere* secondo la sintassi:

```java
"//[delim1][delim2]\n"
```

ad esempio

```java
add("//[*][%]\n1*2%3") restituisce 6
```

Le funzionalità fino ad ora sviluppate rappresentano la **seconda release** (versione finale) del software che deve essere etichettata come `versione 2.0`.
