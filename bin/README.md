[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/JLYnumnD)
# Program de gestionare a unei biblioteci
### Student: Bărbăscu Raul Andrei

## Descriere
Programul pe care îl voi dezvolta se ocupă cu automatizarea activităților legate de împrumuturi și retururi în cadrul unei biblioteci, pentru a ajuta ținutul cont a acestor activități. Mai mult, programul țintește să ajute utilizatorul/cititorul să obțină informații despre diverse cărți intr-un mod ușor și accesibil.

## Obiective
Obiectivele mele pentru acest proiect sunt de a implementa următoarele funcționalități pentru a ușura folosirea unei biblioteci:

* Sistem de căutare cărți (după diverse criterii precum: autor, gen, nume, anul publicării etc.)
* Gestionare stoc (un citior poate vedea dacă o carte este valabilă și câte copii a respectivei cărți sunt; iar un bibliotecar poate modifica stocul cărților conform situației)
* Sistem de împrumut cărți (un bibliotecar poate verifica dacă o carte este sau nu împrumutată, iar utilizatorul poate împrumuta și/sau returna cărți prin aplicație)
    - Verificare stadiu carte (este sau nu valabilă)
    - Împrumut carte
    - Retur carte
* Adăugare/Ștergere cărți (un bibliotecar poate adăuga/șterge o carte, alături de toate detaliile ei, în baza de date)

## Arhitectura
Clasele utilizate vor fi: 
* Carte= Cartea va avea atribute cum ar fi titlu, anul lansării, titlu etc.
* Cititor= Cititorul va fi reprezentat prin nume, adresă (de email de exemplu), ID.
* Bibliotecar= include numele, ID-ul și datele de contact ale bibliotecarilor.

![Screenshot 2024-12-15 065828](https://github.com/user-attachments/assets/5bacb837-9c33-4069-9e9a-512057ac721e)


Relațiile între clase vor fi ca atare:
* Cititorul poate împrumuta cărți.
* Fiecare carte poate fi împrumutată de mai mulți utilizatori în timp, dar doar de unul singur la un moment dat.
* Bibliotecarul poate modifica și verifica cărțile și utilizatorii lor.

## Functionalitati/Exemple utilizare
* Utilizatorul caută o carte și verifică disponibilitatea acesteia.
* Bibliotecarul înregistrează un împrumut de carte pentru un utilizator.
* Sistemul trimite o notificare când data de returnare se apropie. (?)
* Bibliotecarul introduce o nouă carte sau șterge o carte din baza de date.

### Resurse
Markdown Guide, [Online] Available: https://www.markdownguide.org/basic-syntax/ [accesed: Mar 14, 1706]
De adăugat...
