# Aplicatie de gestionare a stocurilor unui magazin

## Pachete si clase:
- Pachetul products:
  * Clasa Product: cu membri precum id, nume, pret etc., din care sunt derivate celelalte 4 clase ce reprezinta tipuri de produse
  * Clasa Food: produse ce au si o data de expirare
  * Clasa Electronic: produse ce au si o garantie
  * Clasa Book: produse ce au si un autor
  * Clasa Clothes: produse ce au si o marime
- Pachetul categories:
  * Clasa abstracta Category: din care sunt derivate celelate 4 clase ce reprezinta cele 4 categorii in care se impart produsele, fiecare categorie continand o lista cu produse de tipul corespunzator
  * Clasa FoodProducts: contine produse de tipul Food
  * Clasa ElectronicProducts: contine produse de tipul Electronic
  * Clasa BookProducts: contine produse de tipul Book
  * Clasa ClothesProducts: contine produse de tipul Clothes
- Pachetul distributors:
  * Clasa Distributor: obiectele de acest tip sunt membri ai obiectelor de tip Product si indica de la ce distribuitor provine un produs
- Pachetul Stock:
  * Clasa Stock: ce contine ca membri cate un obiect de tipul FoodProducts, ElectronicProducts, BookProducts si ClothesProducts.
  * Interfata ServiceInterface: ce contine metodele ce trebuie implementate in clasa Service
  * Clasa Service: in care sunt implementate metode ce actiuneaza asupra unui obiect de tip Stoc(primit ca parametru)
  * Clasa MainClass: in care declaram un obiect s de tip Stock, ce reprezinta stocul magazinului(cu mai multe produse deja adaugate) si asupra caruia putem executa diferite actiuni/interogari
- Pachetul jdbc:
  * Clasa DatabaseConnection: contine metode pentru conectarea la baze de date si inchiderea conexiunii
  * Clasele DistributorsDatabase, ClothesDatabase, FoodDatabase, ElectronicsDatabase, BooksDatabase: ce contin operatii de tip CRUD pentru entitatile respective

## Actiuni/interogari:
1. Afiseaza toate informatiile despre un produs cu un anumit id
2. Afiseaza id-ul si numele tuturor produselor dintr-o categorie
3. Adauga un produs
4. Sterge un produs cu un anumit id
5. Afiseaza toate hainele cu o anumita marime
6. Aplica o reducere de 25% primelor produse n ce urmeaza sa expire
7. Afiseaza id-ul si numele tuturor produselor achizitionate de la un distribuitor
8. Scade cantitatea ramasa in stoc a unui produs
9. Afiseaza produsele cu pretul mai mic decat un anumit numar
10. Afiseaza toate cartile, grupate dupa autor
