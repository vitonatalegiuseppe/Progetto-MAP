/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniba.map.myadventure.classes;

/**
 * @author pierpaolo
 */
public class AdventureCastleGame extends GameDescription {

    @Override
    public void init() throws Exception {
        //Commands
        Command nord = new Command(CommandType.NORD, "nord");
        nord.setAlias(new String[]{"n", "N", "Nord", "NORD", "nord"});
        getCommands().add(nord);
        Command iventory = new Command(CommandType.INVENTORY, "inventario");
        iventory.setAlias(new String[]{"inv"});
        getCommands().add(iventory);
        Command sud = new Command(CommandType.SOUTH, "sud");
        sud.setAlias(new String[]{"s", "S", "Sud", "SUD"});
        getCommands().add(sud);
        Command est = new Command(CommandType.EAST, "est");
        est.setAlias(new String[]{"e", "E", "Est", "EST"});
        getCommands().add(est);
        Command ovest = new Command(CommandType.WEST, "ovest");
        ovest.setAlias(new String[]{"o", "O", "Ovest", "OVEST"});
        getCommands().add(ovest);
        Command comeUp = new Command(CommandType.COME_UP, "sali");
        comeUp.setAlias(new String[]{"ascendi", "arrampicati", "inerpicati"});
        getCommands().add(comeUp);
        Command goDown = new Command(CommandType.GO_DOWN, "scendi");
        goDown.setAlias(new String[]{"discendi", "calati"});
        getCommands().add(goDown);
        Command end = new Command(CommandType.END, "end");
        end.setAlias(new String[]{"end", "fine", "esci", "muori", "ammazzati", "ucciditi", "suicidati", "exit"});
        getCommands().add(end);
        Command look = new Command(CommandType.LOOK_AT, "osserva");
        look.setAlias(new String[]{"guarda", "vedi", "trova", "cerca", "descrivi"});
        getCommands().add(look);
        Command pickup = new Command(CommandType.PICK_UP, "raccogli");
        pickup.setAlias(new String[]{"prendi"});
        getCommands().add(pickup);
        Command open = new Command(CommandType.OPEN, "apri");
        open.setAlias(new String[]{});
        getCommands().add(open);
        Command push = new Command(CommandType.PUSH, "premi");
        push.setAlias(new String[]{"spingi"});
        getCommands().add(push);
        Command fill = new Command(CommandType.FILL, "riempi");
        fill.setAlias(new String[]{"versa", "riempire"});
        getCommands().add(fill);
        Command hit = new Command(CommandType.HIT, "colpisci");
        hit.setAlias(new String[]{"picchia", "colpire", "aggredisci", "distruggi"});
        getCommands().add(hit);
        Command hurl = new Command(CommandType.HURL, "lancia");
        hurl.setAlias(new String[]{"lanciare", "scaglia", "getta"});
        getCommands().add(hurl);
        Command drink = new Command(CommandType.DRINK, "bevi");
        drink.setAlias(new String[]{"sorsegia", "scola", "tracanna"});
        getCommands().add(drink);
        Command empty = new Command(CommandType.EMPTY, "svuota");
        empty.setAlias(new String[]{"vuota", "libera"});
        getCommands().add(empty);
        Command play = new Command(CommandType.PLAY, "gioca");
        play.setAlias(new String[]{"inizia"});
        getCommands().add(play);

        //TODO: creare una funzione id che viene chiamata nei vari costruttori e restituisce un id incrementale evitando di doverlo inserire manualmente        //
        //Rooms - ground floor
        Room exit = new Room(0, "Esterno", "Sei fuori");
        Room stairs = new Room(1, "Scale", "É una stanza completamente spoglia: non ci sono arredi di alcun tipo. L'unica cosa che contiene sono le scale che portano al piano superiore.");
        Room hall2 = new Room(2, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. A ovest e a nord il corridoio prosegue. A sud trovi un cancello; mentre a est una porta aperta.");
        Room hall3 = new Room(3, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. A est e a ovest il corridoio prosegue.");
        // TODO: Ricordarsi di inserire questa descrizione quando entra la prima volta nel primo corridoio: Aprendo porta ti trovi sotto a un porticato che percorre tutto il perimetro del cortile. Da dove ti trovi riesci a vedere che dal sotto il porticato si trovano diversi ingressi a varie stanze. 
        Room hall4 = new Room(4, "Corridoio", "Sei nel corridoio. Di per se non c'e' niente di particolare. Riesci a vedere il giardino. A nord, infatti, trovi la sua entrata, mentre a sud hai la porta per"
                + " andare nell'ingresso. A est e ovest il corridoio prosegue.");
        Room hall5 = new Room(5, "Corridoio", "Sei nel corridoio. Riesci a vedere il cortile. A est e a ovest il corridoio prosegue.");
        Room hall6 = new Room(6, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. A nord, sud ed est il corridoio prosegue.");
        Room hall7 = new Room(7, "Corridoio", "Sei nel corridoio. Riesci a vedere il cortile. A nord e a sud il corridoio prosegue. A ovest c'è l'ingresso di una stanza.");
        Room hall8 = new Room(8, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. A nord e a sud il corridoio prosegue. A est c'è l'ingresso per il giardino.");
        Room hall9 = new Room(9, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. A nord e a sud il corridoio prosegue.");
        Room hall10 = new Room(10, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. A nord e a sud il corridoio prosegue. A ovest vi è l'ingresso di una stanza.");
        Room hall11 = new Room(11, "Corridoio", "Sei nel corridoio. Riesci a vedere il cortile. A sud e a est il corridoio prosegue.");
        Room hall12 = new Room(12, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. A est e a ovest il corridoio prosegue.");
        Room hall13 = new Room(13, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. A est e a ovest il corridoio prosegue. A nord come a sud c'è un ingresso.");
        Room hall14 = new Room(14, "Corridoio", "Sei nel corridoio. Riesci a vedere il cortile. A est e a ovest il corridoio prosegue. A nord vi è l'ingresso di una stanza.");
        Room hall15 = new Room(15, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. Noti che sulle pareti che ti circondano ci sono delle enormi crepe. A ovest e a sud "
                + "il corridoio prosegue.");
        Room hall16 = new Room(16, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. Noti che sulle pareti che ti circondano ci sono delle enormi crepe. A nord e sud il "
                + "corridoio prosegue.");
        Room hall17 = new Room(17, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. A nord e a sud il corridoio prosegue. A est c'è lingresso di una stanza, mentre a ovest l'ingresso al cortile.");
        Room hall18 = new Room(18, "Corridoio", "Sei nel corridoio. Riesci a vedere il cortile. A est e ovest il corridoio prosegue.");
        Room hall19 = new Room(19, "Corridoio", "Sei nel corridoio. A nord il corridoio prosegue. A sud e ovest vedi una porta.");
        Room entryway = new Room(20, "Ingresso", "Sei nell'ingresso. Guardandoti intorno non noti niente di particolare. È un ingresso come tanti: c’è un tappeto con sopra un tavolino,\n"
                + "alle pareti ci sono dei quadri e il tipico lampadario dell’epoca. A nord c'è una porta mentre sulla parete sud c'è la porta dell'ingresso principale \n"
                + "e ci sono un paio di finestre: entrambe però sono sbarrate. (Ti sarebbe piaciuto fuggire così in fretta?!!!).");
        Room closet = new Room(21, "Ripostiglio", "Illuminando la stanza vedi che c'è uno scaffale sul lato, mentre infondo alla stanza vedi quello che sembra un generatore. Ovviamente a Nord trovi l'ingresso da cui sei entrato");
        Room library = new Room(22, "Biblioteca", "Entrando ti trovi difronte un tavolo. Vi è un'unica grande libreria che segue le pareti dell'intera stanza. A est c'è la porta da cui sei entrato alla cui destra "
                + "c’è un mobile con sopra un grande libro: “Registro dei libri”.");
        library.setLook("L'intera libreria è divisa in 5 scaffali. Non tutti gli scaffali sono pieni e sembra che manchi qualche libro. Noti, infatti, che ci sono degli spazi vuoti. Infine, noti che sul tavolo c'è un"
                + " bigliettino con su scritto qualcosa.");
        Room livingroom = new Room(23, "Soggiorno", "Entrando ti trovi davanti un grande camino acceso ai cui lati ci sono due poltrone. Intravedi anche una scrivania. \n"
                + "(Ah, ovviamente a est c'è la porta da cui sei entrato)");
        livingroom.setLook("Osservando meglio sulla scrivania si intravedono dei fogli. Mentre appese alla kappa del camino noti delle fiaccole spente.");
        Room diningroom = new Room(24, "Sala da pranzo", "Sei in un enorme sala da pranzo. C’è un tavolo tutto imbandito con tutto il necessario. Ad un angolo del tavolo noti un uomo, "
                + "forse il maggiordomo della villa. A nord intravedi un ingresso verso un'altra stanza: forse la cucina. "
                + "(Ah, ovviamente a est c'è la porta da cui sei entrato)");
        Room kitchen = new Room(25, "Cucina", "Niente di particolare. Una cucina come tante: credenze, forno, frigorifero e "
                + "cassetti ci sono tutti. Sulla parete sud è presente un ingresso probabilmente verso la sala da pranzo, mentre "
                + "sulla parete est c'è una porta che forse conduce alla dispensa.");
        Room larder = new Room(26, "Dispensa", "La dispensa sembra ben rifornita. Oltre a sacchi di farina e vari salumi e formaggi puoi notare una piccola cantina di vini. A ovest \n"
                + "dell'ingresso vi è una porta che conduce in un'altra stanza, mentre a sud vi è la porta che conduce al corridoio.");
        larder.setLook("Guardandoti in giro il tuo sguardo viene attirato dalla piccola cantina di vini. In particolare, noti una bottiglia \n"
                + "di vino al cui interno brilla qualcosa.");
        Room roomOfDebris = new Room(27, "Stanza crollata", "Praticamente è un cumulo di macerie. Non c’è niente se non pietre e qualche foglio/pezzo di carta.");
        Room armory = new Room(28, "Armeria", "Delle candele accese ti permettono di vedere. Oltre ad un’immensa collezione di fucili, pistole e lance puoi notare anche una serie di oggetti che non sono propriamente armi: caschi, armature, rampini,"
                + " scarpe, occorrenti per giardinaggio, ecc. Inoltre, vedi anche delle panche. Alle tue spalle, sulla parete nord c'è l'ingresso da cui sei entrato. Ma ad attirare la tua attenzione"
                + "è l'echeggiare di rumore.");
        armory.setLook("Una panca, in particolare, attira la tua attenzione: su di essa c’è un uomo che dorme. Appena lo focalizzi ti balza all’occhio la chiave che gli pende dal collo.");
        Room bathroom1 = new Room(29, "Bagno", "É un normale bagno. Water, bidet, lavandino e vasca. Niente di particolare, se non fosse che a un angolo della vasca vedi una figura."
                + "É un po' strana: sembra trasparente. Appena ti avvicini noti che riesci a vederci attraverso: si tratta di un fantasma!!!! (Ah, ovviamente a ovest c'è la porta da cui sei entrato.)");
        Room yard = new Room(30, "Cortile", "Al suo interno vedi alberi, cespugli, fiori e siepi.");
        yard.setLook("Guardando meglio, la prima cosa che ti balza all’occhio è un enorme cilindro che sembra alto circa 3 metri al cui interno c’è una chiave esposta. Ti rendi conto anche che una parte del cortile"
                + " è coperta da un balcone che sembra essere l’affaccio di qualche stanza del primo piano.");

        //secondo piano
        Room stairs_2 = new Room(31, "Scale", "Salendo ti ritrovi un’ampia stanza da cui, ben presto, capisci che si tratta di un corridoio che circonda l’intero palazzo.\n"
                + "(Ovviamente ci sono le scale che scendono al piano inferiore)");
        stairs_2.setLook("C'è ben poco arredamento: un tappeto posizionato al centro della stanza sembra percorrere l’intero corridoio, ci sono delle sculture.");
        Room hall2_2 = new Room(32, "Corridoio", "Sei nel corridoio. L'ambiente rimane pressochè lo stesso: ci sono delle sculture e dei quadri. C'è anche una finestra."
                + " A ovest e a nord il corridoio prosegue. A sud vai verso le scale.");
        Room hall3_2 = new Room(33, "Corridoio", "Sei nel corridoio. L'ambiente rimane pressochè lo stesso: ci sono delle sculture e dei quadri."
                + " A ovest e a est il corridoio prosegue. A sud vai verso le scale.");
        Room hall4_2 = new Room(34, "Corridoio", "Sei nel corridoio. L'ambiente rimane pressochè lo stesso: ci sono delle sculture e dei quadri. C'è anche una finestra."
                + " A ovest e a est il corridoio prosegue. A nord vi è l'ingresso di una stanza.");
        Room hall5_2 = new Room(35, "Corridoio", "Sei nel corridoio. L'ambiente rimane pressochè lo stesso. A sud, dove dovrebbe esserci l'ingresso per la torre c’è una scultura. "
                + " A ovest e a est il corridoio prosegue.");
        hall5_2.setLook("La scultura raffigura un dio Ares, il dio greco della guerra, in una posa particolare: è in piedi con il braccio sinistro che regge uno scudo, mentre il"
                + " braccio desto mantiene una spada sollevata.");
        Room hall6_2 = new Room(36, "Corridoio", "Sei nel corridoio. L'ambiente rimane pressochè lo stesso: ci sono delle sculture e dei quadri."
                + " A nord e a est il corridoio prosegue. ");
        Room hall7_2 = new Room(37, "Corridoio", "Sei nel corridoio. L'ambiente rimane pressochè lo stesso: ci sono delle sculture e dei quadri."
                + " A nord e a sud il corridoio prosegue. ");
        Room hall8_2 = new Room(38, "Corridoio", "Sei nel corridoio. L'ambiente rimane pressochè lo stesso: ci sono delle sculture e dei quadri. C'è anche una finesta s, rigorosamente sbarrata."
                + " A nord e a sud il corridoio prosegue. ");
        Room hall9_2 = new Room(39, "Corridoio", "Sei nel corridoio. L'ambiente rimane pressochè lo stesso: ci sono delle sculture e dei quadri."
                + " A nord e a sud il corridoio prosegue. A est entri in una stanza");
        Room hall10_2 = new Room(40, "Corridoio", "Sei nel corridoio. L'ambiente è pressochè lo stesso: ci sono delle sculture e dei quadri."
                + " A nord e a sud il corridoio prosegue.");
        Room hall11_2 = new Room(41, "Corridoio", "Sei nel corridoio. L'ambiente rimane pressochè lo stesso: ci sono delle sculture e dei quadri."
                + " A nord e a sud il corridoio prosegue. A est c'è una porta chiusa");
        Room hall12_2 = new Room(42, "Corridoio", "Sei nel corridoio. L'ambiente rimane pressochè lo stesso: ci sono delle sculture e dei quadri."
                + " A sud e a est il corridoio prosegue.");
        Room hall13_2 = new Room(43, "Corridoio", "Sei nel corridoio. L'ambiente rimane pressochè lo stesso: ci sono delle sculture e dei quadri."
                + " A ovest e a est il corridoio prosegue.");
        Room hall14_2 = new Room(44, "Corridoio", "Sei nel corridoio. L'ambiente rimane pressochè lo stesso: ci sono delle sculture e dei quadri."
                + " A ovest il corridoio prosegue. A sud c'è lingresso ad una stanza. A est vedi il nulla: il cielo risplende. Difronte a te c'è "
                + "un precipizio. Probabilmente questa parte della casa è crollata un po' di tempo fa. ");
        Room hall18_2 = new Room(45, "Corridoio", "Sei nel corridoio. L'ambiente rimane pressochè lo stesso: ci sono delle sculture e dei quadri."
                + " A sud il corridoio prosegue. A nord vedi il nulla: il cielo risplende. Difronte a te c'è un precipizio. Probabilmente questa "
                + "parte della casa è crollata un po' di tempo fa.");
        Room hall19_2 = new Room(46, "Corridoio", "Sei nel corridoio. L'ambiente rimane pressochè lo stesso: ci sono delle sculture e dei quadri."
                + " A nord e a sud il corridoio prosegue. A ovest c'è l'ingresso di una stanza. ");
        Room hall20_2 = new Room(48, "Corridoio", "Sei nel corridoio. L'ambiente rimane pressochè lo stesso: ci sono delle sculture e dei quadri."
                + " A nord e a sud il corridoio prosegue.");
        Room anteroom = new Room(49, "Anticamera", "La prima cosa che ti colpisce entrando è l’enorme finestrone aperto che affaccia sul cortile. "
                + "Ad entrambi i lati della stanza ci sono delle porte, una chiusa e l’altra aperta. Al centro ci sono dei divani posti intorno ad un tavolino da caffè su cui ci sono delle riviste di abiti da sposa. ");
        Room bedroomBoy = new Room(50, "Camera da letto del figlio", "Sei nella camera da letto di un bambino.\n Non ci sono altri ingressi a parte quello cui sei entrato, c'è un armadio, un letto, un comodino e una scrivania.");
        bedroomBoy.setLook("Osservando meglio la stanza la tua attenzione cade sulla scrivania: noti che ci sono delle foto.");
        Room bedroomGirl = new Room(51, "Camera da letto della figlia", "Sei nella camera da letto di una bambina.\n Non ci sono altri ingressi se non quello da cui sei entrato, vedi un letto con il comodino,"
                + " un armadio la cui anta è aperta: si intravedono abiti da bambina. Infine c'è un mobile con uno specchio.");
        Room bathroom_2 = new Room(52, "Bagno", "Normale bagno. Contiene un quadro che raffigura una persona che si arrampica dal piano terra al balcone con una corda. A est c'è l'ingresso da cui sei entrato");
        Room studio = new Room(53, "Studio", "C’è una scrivania centrale con dei documenti. Davanti ad essa ci sono delle sedie, mentre dietro c’è un piccolo camino. A nord c’è una piccola vetrinetta al cui interno ci sono dei "
                + "liquori e dei bicchieri di vetro. Accanto alla porta di ingresso c’è un quadro che raffigura due bambini accanto alla statua che c’è all’ingresso.");
        studio.setLook("Osservando meglio i documenti si nota in cima una lettera. L'attenzione maggiore, però, l’attira il quadro appeso alla parete: noti, infatti, che alle spalle di Ares si intravede un ingresso e a differenza"
                + " della statua vista in precedenza questa ha il braccio destro con la lama che punta verso il basso.");
        Room mainRoom_1 = new Room(54, "Camera padronale", "Entrando nella stanza ti rendi conto che questa doveva essere la stanza da letto dei proprietari della casa. È enorme!! Al centro c’è un enorme letto a baldacchino. Su "
                + "lato est c’è un enorme cabina armadio, ma parte della stanza, sul lato nord/est, è piena di macerie. C’è anche qui un enorme camino con poste sulla cappa due spade da cavalieri. Davanti al letto c’è un baule "
                + "chiuso. Tutta la stanza è tappezzata di quadri che rappresentano ambienti della casa, o i proprietari o i figli. A sud c’è un enorme finestra chiusa che dà su un balcone che si affaccia sul cortile. (Ovviamente "
                + "a nord c'è lingresso da cui sei entrato) ");
        mainRoom_1.setLook("Avvicinandoti al letto noti che c'è qualcuno che sembra dormire. Non appena ti avvicini, l'uomo si alza...");
        Room mainRoom_2 = new Room(55, "Camera padronale", "Entrando nella stanza ti rendi conto che questa doveva essere la stanza da letto dei proprietari della casa. È enorme!! Al centro c’è un enorme letto a baldacchino. Su "
                + "lato est c’è un enorme cabina armadio, ma parte della stanza, sul lato nord/est, è piena di macerie. C’è anche qui un enorme camino con poste sulla cappa due spade da cavalieri. Davanti al letto c’è un baule "
                + "chiuso. Tutta la stanza è tappezzata di quadri che rappresentano ambienti della casa, o i proprietari o i figli. Ovviamente a sud c'è lingresso da cui sei entrato. ");
        Room tower = new Room(56, "TOrre", "Attraversato l'ingresso dietro la statua ti trovi in uno stretto corridoio. Al termine una luce ti attende. Man mano che ti avvicini senti la rabbia che sale, ma allo stesso"
                + " tempo paura nel temere per quello che può aver fatto quel pazzo alla tua amata Stecy. É li che è tenuta nascosta? Come stara? Arrivato alla fine del corridoio ti trovi difronte colui che ha "
                + "organizzato tutto: Mister X. Il luogo in cui si nasconde, la torre, è una specie di ripostiglio. sembra che ci siano dei mobili, ma questi sono tutti coperti da teli bianchi. L'unico oggetto scoperto,"
                + " una sedia, è quella su cui è legata Stecy. Mister X, invece, è appoggiato a quella che sembra una scrivania.");
        Room balconyAnteroom = new Room(57, "Balcone anticamera", "Affacciandoti dal balcone riesci a vdere l'intero cortile e il balcone difronte. li però la finestra sembra chiusa."
                + "A sud trovi l'ingresso alla stanza.");
        Room edge = new Room(58, "Precipizio", "É stato bello conoscerti. Mentre cadi vedi trascorrere tutta la tua vita. ogni tanto colpisci qualche pietra. Mi dispiace, sei morto");
        Room balconyMainRoom = new Room(59, "Balcone camera padronale", "Affacciandoti dal balcone riesci a vdere l'intero cortile e il balcone difronte. Li però la finestra sembra aperta."
                + "A nord trovi l'ingresso alla stanza.");

        //map
        stairs.setNorth(hall2);
        stairs.setComeUp(stairs_2);
        entryway.setNorth(hall4);
        entryway.setSouth(exit);
        hall2.setEast(bathroom1);
        hall2.setWest(hall3);
        hall2.setNorth(hall18);
        hall2.setSouth(stairs);
        hall3.setEast(hall2);
        hall3.setWest(hall4);
        hall4.setNorth(yard);
        hall4.setSouth(entryway);
        hall4.setEast(hall3);
        hall4.setWest(hall5);
        hall5.setEast(hall4);
        hall5.setWest(hall6);
        hall6.setSouth(hall19);
        hall6.setEast(hall15);
        hall6.setNorth(hall7);
        hall7.setNorth(hall8);
        hall7.setSouth(hall6);
        hall7.setWest(livingroom);
        hall8.setNorth(hall9);
        hall8.setSouth(hall7);
        hall8.setEast(yard);
        hall9.setNorth(hall10);
        hall9.setSouth(hall8);
        hall10.setNorth(hall11);
        hall10.setSouth(hall9);
        hall10.setWest(diningroom);
        hall11.setSouth(hall10);
        hall11.setEast(hall12);
        hall12.setEast(hall13);
        hall12.setWest(hall11);
        hall13.setNorth(larder);
        hall13.setSouth(yard);
        hall13.setEast(hall14);
        hall13.setWest(hall12);
        hall14.setEast(hall15);
        hall14.setWest(hall13);
        hall14.setNorth(roomOfDebris);
        hall15.setWest(hall14);
        hall15.setSouth(hall16);
        hall16.setNorth(hall15);
        hall16.setSouth(hall17);
        hall17.setNorth(hall16);
        hall17.setSouth(hall18);
        hall17.setWest(yard);
        hall17.setEast(armory);
        hall18.setNorth(hall17);
        hall18.setSouth(hall2);
        hall19.setNorth(hall6);
        hall19.setSouth(closet);
        hall19.setWest(library);
        closet.setNorth(hall19);
        library.setEast(hall19);
        livingroom.setEast(hall7);
        diningroom.setNorth(kitchen);
        diningroom.setEast(hall10);
        kitchen.setSouth(diningroom);
        kitchen.setEast(larder);
        larder.setWest(kitchen);
        larder.setSouth(hall13);
        armory.setWest(hall17);
        bathroom1.setWest(hall2);
        yard.setSouth(hall4);
        yard.setNorth(hall13);
        yard.setWest(hall8);
        yard.setEast(hall17);
        roomOfDebris.setSouth(hall14);

        stairs_2.setNorth(hall2_2);
        stairs_2.setGoDown(stairs);
        hall2_2.setNorth(hall20_2);
        hall2_2.setSouth(stairs_2);
        hall2_2.setWest(hall3_2);
        hall3_2.setSouth(stairs_2);
        hall3_2.setWest(hall4_2);
        hall3_2.setEast(hall2_2);
        hall4_2.setEast(hall3_2);
        hall4_2.setWest(hall5_2);
        hall4_2.setNorth(anteroom);
        hall5_2.setWest(hall6_2);
        hall5_2.setEast(hall4_2);
        hall5_2.setSouth(tower);
        hall6_2.setEast(hall5_2);
        hall6_2.setNorth(hall7_2);
        hall7_2.setSouth(hall6_2);
        hall7_2.setNorth(hall8_2);
        hall8_2.setNorth(hall9_2);
        hall8_2.setSouth(hall9_2);
        hall9_2.setNorth(hall10_2);
        hall9_2.setSouth(hall8_2);
        hall9_2.setEast(studio);
        hall10_2.setNorth(hall11_2);
        hall10_2.setSouth(hall9_2);
        hall11_2.setNorth(hall12_2);
        hall11_2.setSouth(hall10_2);
        hall12_2.setEast(hall13_2);
        hall12_2.setSouth(hall11_2);
        hall13_2.setEast(hall14_2);
        hall13_2.setWest(hall12_2);
        hall14_2.setEast(edge);
        hall14_2.setWest(hall13_2);
        hall14_2.setSouth(mainRoom_1);
        hall18_2.setNorth(edge);
        hall18_2.setSouth(hall19_2);
        hall19_2.setNorth(hall18_2);
        hall19_2.setSouth(hall20_2);
        hall19_2.setWest(bathroom_2);
        hall20_2.setNorth(hall19_2);
        hall20_2.setSouth(hall2_2);
        bathroom_2.setEast(hall19_2);
        anteroom.setNorth(balconyAnteroom);
        anteroom.setSouth(hall4_2);
        anteroom.setWest(bedroomBoy);
        anteroom.setEast(bedroomGirl);
        bedroomGirl.setWest(anteroom);
        bedroomBoy.setEast(anteroom);
        studio.setNorth(mainRoom_2);
        studio.setWest(hall9_2);
        mainRoom_2.setSouth(studio);
        mainRoom_2.setEast(mainRoom_1);
        mainRoom_1.setNorth(hall14_2);
        mainRoom_1.setSouth(balconyMainRoom);
        mainRoom_1.setEast(mainRoom_2);
        balconyMainRoom.setNorth(mainRoom_1);
        tower.setNorth(hall5_2);
        exit.setNorth(entryway);

        getRooms().add(kitchen);
        getRooms().add(livingroom);
        getRooms().add(hall2);
        getRooms().add(hall3);
        getRooms().add(hall4);
        getRooms().add(hall5);
        getRooms().add(hall6);
        getRooms().add(hall7);
        getRooms().add(hall8);
        getRooms().add(hall9);
        getRooms().add(hall10);
        getRooms().add(hall11);
        getRooms().add(hall12);
        getRooms().add(hall13);
        getRooms().add(hall14);
        getRooms().add(hall15);
        getRooms().add(hall16);
        getRooms().add(hall17);
        getRooms().add(hall18);
        getRooms().add(hall19);
        getRooms().add(bathroom1);
        getRooms().add(armory);
        getRooms().add(yard);
        getRooms().add(larder);
        getRooms().add(entryway);
        getRooms().add(library);
        getRooms().add(diningroom);
        getRooms().add(stairs);
        getRooms().add(closet);
        getRooms().add(roomOfDebris);

        getRooms().add(hall2_2);
        getRooms().add(hall3_2);
        getRooms().add(hall4_2);
        getRooms().add(hall5_2);
        getRooms().add(hall6_2);
        getRooms().add(hall7_2);
        getRooms().add(hall8_2);
        getRooms().add(hall9_2);
        getRooms().add(hall10_2);
        getRooms().add(hall11_2);
        getRooms().add(hall12_2);
        getRooms().add(hall13_2);
        getRooms().add(hall14_2);
        getRooms().add(hall18_2);
        getRooms().add(hall19_2);
        getRooms().add(hall20_2);
        getRooms().add(anteroom);
        getRooms().add(bedroomBoy);
        getRooms().add(bedroomGirl);
        getRooms().add(mainRoom_1);
        getRooms().add(mainRoom_2);
        getRooms().add(bathroom_2);
        getRooms().add(studio);
        getRooms().add(tower);
        getRooms().add(balconyAnteroom);
        getRooms().add(balconyMainRoom);
        getRooms().add(edge);
        getRooms().add(exit);

        //obejcts primo piano
        // ingresso
        ObjectAdv doorExit = new ObjectAdv(64, "Portone", "Sembrerebbe la porta di ingresso, chissà se si può aprire");
        doorExit.setPickupable(false);
        doorExit.setOpenable(true);
        doorExit.setAlias(new String[]{"porta", "uscita"});
        entryway.getObjects().add(doorExit);
        exit.getObjects().add(doorExit);

        // ripostiglio 
        ObjectAdvContainer rack = new ObjectAdvContainer(6, "scaffale", "uno scaffale dove al suo interno sembra ci sono chiodi, martello, corda, nastro, carburante, secchio, palanghino");
        rack.setPickupable(false);
        rack.setOpen(false);
        rack.setOpenable(true);
        rack.setAlias(new String[]{"mobile", "mensola"});
        closet.getObjects().add(rack);
        ObjectAdv rope = new ObjectAdv(7, "corda", "una corda molto resistente");
        rope.setAlias(new String[]{"laccio", "fune"});
        ObjectAdv scotch = new ObjectAdv(8, "scotch", "un semplice nastro adesivo");
        scotch.setFragile(true);
        scotch.setAlias(new String[]{"nastro"});
        ObjectAdv fuel = new ObjectAdv(9, "benzina", "una tanica di benzina piena");
        fuel.setAlias(new String[]{"carburante", "tanica", "combustibile"});
        ObjectAdv hammer = new ObjectAdv(10, "martello", "un martello molto pratico per ottime martellate");
        hammer.setAlias(new String[]{"mazzola"});
        ObjectAdv nails = new ObjectAdv(11, "chiodi", "Dei chiodi molto utili se si ha un martello");
        nails.setAlias(new String[]{"puntine", "viti"});
        ObjectAdv bucket = new ObjectAdv(12, "secchio", "un secchio pieno d'acqua");
        bucket.setFillable(true);
        bucket.setAlias(new String[]{"bidone"});
        ObjectAdv crowbar = new ObjectAdv(13, "palanghino", "un palanghino utile per qualsiasi idea di scasso vi passi per la testa");
        crowbar.setAlias(new String[]{"leva"});
        rack.add(rope);
        rack.add(scotch);
        rack.add(fuel);
        rack.add(hammer);
        rack.add(nails);
        rack.add(bucket);
        rack.add(crowbar);

        // sala da pranzo
        // TODO: se avanza il tempo: il cibo all'interno dei piatti è avvelenato e il personaggio perde una vita se lo mangia.
        ObjectAdv dish = new ObjectAdv(15, "piatto", "Un piatto con ancora del cibo al loro interno, chissà se è buono");
        dish.setAlias(new String[]{"stoviglia", "porcellana"});
        dish.setFragile(true);
        diningroom.getObjects().add(dish);
        ObjectAdv silverware = new ObjectAdv(16, "posata", "Utili per afferrare cosa c'è nel piatto");
        silverware.setAlias(new String[]{"argenteria"});
        diningroom.getObjects().add(silverware);
        ObjectAdv glass = new ObjectAdv(17, "bicchiere", "Utili per bere qualsiasi fluido ");
        glass.setAlias(new String[]{"calice", "tazza"});
        glass.setFragile(true);
        diningroom.getObjects().add(glass);
        ObjectAdv candle = new ObjectAdv(19, "candela", "Ottime per illuminare e scaldare un ambiente");
        candle.setAlias(new String[]{"lumino"});
        candle.setFragile(true);
        diningroom.getObjects().add(candle);
        
        AdvPerson butler = new AdvPerson(2, "Ambrogio", "É il magiordomo di questo castello. gurdandolo bene noti due cose: "
                + "al collo ha appesa una chiave e dal suo volto traspare la lieve, se pur marcata, intenzione di farti fuori...", 1);
        butler.setAlias(new String[]{"cameriere", "maggiordomo"});
        butler.setPickupable(false);
        diningroom.getObjects().add(butler);
        //TOTO: da rivedere sto fatto della chiave posseduta dal maggiorndomo
        /*ObjectAdv key1 = new ObjectAdv(21, "chiave", "una chiave che probabilmente può aprire una serratura");
        key1.setAlias(new String[]{"chiavi"});
        butler.add(key1);*/
        //TODO: creare una classe persona sottoclasse di oggetti. tra gli attributi c'è vita che indica la vita del personaggio. se la vita arriva a zero la persona muore.
        // il giocatore per recuperare la vita deve mangiare o bere qualcosa.

        //oggetti biblioteca
        ObjectAdv card = new ObjectAdv(22, "bigliettino", ""); //TODO: da inserire la descrizione del foglietto
        card.setAlias(new String[]{"foglio", "lettera"});
        //TODO: inserire gli indovinelli che ti conducono alla chiave
        library.getObjects().add(card);
        //TODO: se c'è tempo ampliare i libri dello scaffale e aggiungere nome del libro
        ObjectAdvContainer bookcase = new ObjectAdvContainer(23, "scaffale", "nome libro");
        bookcase.setPickupable(false);
        bookcase.setAlias(new String[]{"libreria",});
        library.getObjects().add(bookcase);
        ObjectAdv book1 = new ObjectAdv(24, "libro", "questo libro sembra essere piu pulito rispetto a gli altri");
        book1.setPickupable(true);
        book1.setAlias(new String[]{"testo"});
        bookcase.add(book1);
        ObjectAdvContainer secretbox = new ObjectAdvContainer(31, "scompartimento", "al suo interno c'è una chiave insieme ad un odore di qualcosa andato a male,"
                + " sembra che qualcuno ci abbia lasciato il pranzo");
        secretbox.setAlias(new String[]{"ripostiglio", "nascondiglio"});
        library.getObjects().add(secretbox);
        ObjectAdv key2 = new ObjectAdv(36, "chiave", "una chiave utile per aprire una serratura, chissà quale");
        key2.setAlias(new String[]{"chiave"});
        secretbox.add(key2);

        //ogetti soggiorno
        //TODO: codificare il fatto di svuotare il secchio sul fuoco
        ObjectAdvContainer chimney = new ObjectAdvContainer(28, "Camino", "Un bel caminetto con del fuoco accesso, se hai con te delle salsicce puoi fare un ottimo spuntino.");
        chimney.setAlias(new String[]{"stufa", "caminetto"});
        livingroom.getObjects().add(chimney);
        //TODO: modificare la lettera facendola diventare un bigliettino dello psicopatico che ti dice diche se vuoli la chiave la devi prendere dal camino che è acceso.
        ObjectAdv mail = new ObjectAdv(29, "fogli", "Uno dei fogli sembra una lettera. Parla di un certo Franchino che va in giro per il paese a rubare. Spesso \n"
                + "entra nelle case e indisturbato si aggira recuperando tutto quello che gli sembra preziono. Una frase \n"
                + "ti stuzzica più delle altre: \"Per sentiri più al sicuro, il nonno ha costruito una nucchia all'interno \n"
                + "del camino in cui nascondere le cose più preziose\". Il resto della lettera racconta di feste e banchetti.");
        mail.setAlias(new String[]{"busta", "lettera"});
        livingroom.getObjects().add(mail);
        ObjectAdv key3 = new ObjectAdv(30, "chiave", "una chiave utile per aprire una serratura, chissà quale");
        key3.setAlias(new String[]{"3"});
        chimney.add(key3);
        
        //oggetti cucina 
        //TODO: inserire degli oggetti nella cucina che permettano di recuperare la vita
        //TODO: se avanza tempo mettere altri oggetti che può prendere.
        //TODO: rivedere la gestione della porta tra cucina e dispensa

        //oggetti dispensa
        ObjectAdv doorlarder = new ObjectAdv(25, "porta dispensa", "una porta che collega a qualche stanza, chissa se si può aprire");
        doorlarder.setOpenable(true);
        doorlarder.setPickupable(false);
        doorlarder.setAlias(new String[]{"porta"});
        larder.getObjects().add(doorlarder);
        kitchen.getObjects().add(doorlarder);
        ObjectAdv foodstocks = new ObjectAdv(33, "scorte", "qui c'è del cibo per sfamare l'africa");
        foodstocks.setAlias(new String[]{"viveri", "dispensa"});
        larder.getObjects().add(foodstocks);
        ObjectAdv winecellar = new ObjectAdv(34, "cantina", "una preziosa scorta di vini profumati ed inebrianti ottimi per le migliori feste da palazzo");
        winecellar.setAlias(new String[]{"deposito", "scantinato"});
        winecellar.setPickupable(false);
        larder.getObjects().add(winecellar);
        ObjectAdvContainer winebottle = new ObjectAdvContainer(35, "bottiglia", "Una normale bottiglia al cui interno sembra esserci una chiave");
        winebottle.setOpenable(true);
        winebottle.setFragile(true);
        winebottle.setFilled(true);
        winebottle.setAlias(new String[]{"vino"});
        larder.getObjects().add(winebottle);
        ObjectAdv key4 = new ObjectAdv(35, "chiave", "una chiave utile per aprire una serratura, chissà quale");
        key4.setAlias(new String[]{"chiave"});
        winebottle.add(key4);
        //TODO: per simulare che il tizio è ubriaco dopo aver bevuto il vino, si tolgono alcuni punti vita.
        //TODO: se avanza tempo gestire un thread che faccia recuperare la vita dopo che si è ubricacato.

        //oggetti stanza crollata
        ObjectAdv doorDebris = new ObjectAdv(26, "portaservitu", "Una porta... Chissa se puo essere aperta??!!!");
        doorDebris.setOpenable(true);
        doorDebris.setPickupable(false);
        doorDebris.setAlias(new String[]{"porta"});
        roomOfDebris.getObjects().add(doorDebris);
        hall14.getObjects().add(doorDebris);
        //TODO: gestire l'accesso alla stanza con la chiave.

        //ogetti armeria
        ObjectAdv rifle = new ObjectAdv(39, "fucile", "un ottima arma per incutere timore a chi hai di fronte, inutile se mancano le munizioni");
        rifle.setAlias(new String[]{"carabina"});
        armory.getObjects().add(rifle);
        ObjectAdv glock17 = new ObjectAdv(40, "pistola", "un arma abbastanza pratica per eliminare i tuoi nemici, ma a senza munizione puoi usarla come martello");
        glock17.setAlias(new String[]{"revolver"});
        armory.getObjects().add(glock17);
        ObjectAdv spear = new ObjectAdv(41, "lancia", "un arma usata nell'era glaciale per abbattere i mammut, ottima per il suo periodo storico");
        spear.setAlias(new String[]{"giavellotto"});
        armory.getObjects().add(spear);
        ObjectAdv sword = new ObjectAdv(42, "spada", "ottima nelle grandi battaglie, questa sembra sia salda al muro");
        sword.setAlias(new String[]{"lama"});
        armory.getObjects().add(sword);
        ObjectAdv key5 = new ObjectAdv(43, "chiave", "una chiave utile per aprire una serratura, chissà quale");
        key5.setAlias(new String[]{"chiave"});
        armory.getObjects().add(key5);
        AdvPerson guardian = new AdvPerson(44, "Guardiano", "Lui è Robert il guardiano di questo castello, a lui non sfugge nulla, neanche quando dorme", 7);
        guardian.setAlias(new String[]{"custode", "sorvegliante"});
        guardian.setPickupable(false);
        armory.getObjects().add(guardian);
        ObjectAdv GrapplingHook = new ObjectAdv(45, "rampino", "un oggetto che se lanciato si aggrappa ovunque, ma inutile senza una corda");
        //TODO: inserire l'azione che unisce gli oggetti e modificare la descrizione del rampino
        armory.getObjects().add(GrapplingHook);
        //TODO: cambiare le vite dei nemici

        // oggetti bagno
        ObjectAdv ghost = new ObjectAdv(46, "fantasma", "un anima in pena che sembra sia molto affezzionata a questa stanza, chissa cosa c'è che richiama la sua attenzione");
        ghost.setAlias(new String[]{"spettro"});
        ghost.setPickupable(false);
        bathroom1.getObjects().add(ghost);
        ObjectAdv key6 = new ObjectAdv(47, "chiave", "una chiave utile per aprire una serratura, chissà quale");
        key6.setAlias(new String[]{"chiave"});
        bathroom1.getObjects().add(key6);

        //scale che portano al secondo piano
        ObjectAdv gate = new ObjectAdv(48, "cancello", "Questo cancello ti blocca la strada, trova la chiave che lo apre o trova un altro modo per oltrepassarlo");
        gate.setOpenable(true);
        gate.setPickupable(false);
        gate.setAlias(new String[]{"inferiata"});
        stairs.getObjects().add(gate);
        hall2.getObjects().add(gate);
        //TODO: controllare se servono ancora le scale.
        ObjectAdv steps = new ObjectAdv(60, "Scale", "Un'enorme scalinata ornata con un gran tappeto rosso.");
        steps.setPickupable(false);
        steps.setOpen(true);
        steps.setAlias(new String[]{"rampa", "gradini"});
        stairs.getObjects().add(steps);
        stairs_2.getObjects().add(steps);

        //TODO: le chiavi devono essere distinte in qualche maniera altrimenti una volta messe nell'inventario daranno problemi.
        //corridioio secondo piano
        ObjectAdv ares = new ObjectAdv(49, "scultura", "un scultura molto bella che raffigura ares il dio della guerra, Ares");
        ares.setAlias(new String[]{"statua"});
        ares.setPushable(true);
        hall5_2.getObjects().add(ares);

        //studio secondo piano
        ObjectAdv mail2 = new ObjectAdv(50, "lettera", "Caro james, se stai leggendo questa lettera vuole dire che sono fuggito, mi avevano quasi preso quei maledetti cosacchi,"
                + " menumale che mio nonno fece costruire un passaggio segreto per fuggire dal castello dove sgattaiolava da sua moglie per andare a trovare le sue giovani amiche del bordello,"
                + "inoltre questo passaggio portava in cima ad una torre dove nascondeva la sua collezione di vini, il passaggio è raffigurato in un quadro, trova l'ingresso e portami una di quelle bottiglie,"
                + "ti aspetto fuori dalle mura del castello, mi raccomando james non dimenticarti le bottiglie!");
        mail2.setAlias(new String[]{"biglietto"});
        studio.getObjects().add(mail2);
        ObjectAdv square = new ObjectAdv(51, "quadro", "il quadro raffigura la statua di ares il dio della guerra con un braccio abbassato");
        square.setAlias(new String[]{"dipinto"});
        studio.getObjects().add(square);

        //bagno secondo piano
        ObjectAdv square2 = new ObjectAdv(52, "quadro", "il quadro raffigura una persona che si arrampica sul balcone dal cortile del castello, usando un rampino, un tizio molto abile");
        square2.setAlias(new String[]{"dipinto"});
        bathroom_2.getObjects().add(square2);

        // oggetti camera padronaria
        ObjectAdv sword1 = new ObjectAdv(53, "Spada", "Arma da combattimento ravvicinato");
        sword1.setAlias(new String[]{"lama", "fioretto", "scimitarra"});
        mainRoom_2.getObjects().add(sword1);
        ObjectAdv sword2 = new ObjectAdv(55, "Spada", "Arma da combattimento ravvicinato");
        sword2.setAlias(new String[]{"lama", "fioretto", "scimitarra"});
        mainRoom_2.getObjects().add(sword2);
        ObjectAdv doorWardrobe = new ObjectAdv(57, "Porta cabina armadio", "Una porta... Chissa se puo essere aperta??!!!");
        doorWardrobe.setPickupable(false);
        doorWardrobe.setAlias(new String[]{"porta"});
        mainRoom_1.getObjects().add(doorWardrobe);
        ObjectAdv window = new ObjectAdv(58, "Finestrone", "Un enorme Finestrone che affaccia sul balcone. Chissa se puo essere aperta??!!!");
        window.setPickupable(false);
        window.setAlias(new String[]{"finestra", "lucernario"});
        mainRoom_1.getObjects().add(window);
        balconyMainRoom.getObjects().add(window);
        AdvPerson henchman = new AdvPerson(44, "Scagnozzo", "un uomo che sembra stia dormendo... Non far rumore altrimenti lo svegli.", 7);
        henchman.setAlias(new String[]{"lacche", "tirapiedi"});
        henchman.setPushable(true);
        mainRoom_1.getObjects().add(henchman);
        ObjectAdv chest = new ObjectAdv(59, "Baule", "Un baule della stessa larghezza del letto. sembra chiuso... Vuoi sapere cosa contiene, razza di ficcanaso?!!!");
        chest.setPickupable(false);
        chest.setOpenable(true);
        chest.setAlias(new String[]{"Cassapanca", "forziere"});
        mainRoom_1.getObjects().add(chest);

        //oggetti torre 
        AdvPerson misterX = new AdvPerson(53, "MisterX", "si presenta con una benda all'occhio, un barbone non curata e un fare minaccioso, il classico tipo losco da non farti mai nemico", 10);
        misterX.setAlias(new String[]{"boss", "cattivo"});
        tower.getObjects().add(misterX);
        AdvPerson stecy = new AdvPerson(54, "Stecy", "una bella ragazza con dei lineamenti del viso armoniosi e proporzionati con occhi grandi e luminosi, la classica ragazza acqua e sapone", 3);
        stecy.setAlias(new String[]{"ragazza"});
        tower.getObjects().add(stecy);

        //set starting room
        setCurrentRoom(kitchen);
    }

    @Override
    public void nextMove(ParserOutput p) {
        
        Controller controller = new Controller();
        if (p.getCommand() == null) {
            Engine2.appendToScreenEngine("Non ho capito cosa devo fare! Prova con un altro comando.");
        } else {
            //move
            boolean noroom = false;
            boolean move = false;
            if (p.getCommand().getType() == CommandType.NORD) {
                if (getCurrentRoom().getNorth() != null) {
                    if (controller.doorController(getCurrentRoom(), getCurrentRoom().getNorth())) {
                        getCurrentRoom().changePearsonStatus(false);
                        setCurrentRoom(getCurrentRoom().getNorth());
                        move = true;
                    } else {
                        Engine2.appendToScreenEngine("Sembra che la porta sia chiusa, percaso ti ritrovi qualche chiave nell'inventario?");
                    }
                } else {
                    noroom = true;
                }
            } else if (p.getCommand().getType() == CommandType.SOUTH) {
                if (getCurrentRoom().getSouth() != null) {
                    if (controller.doorController(getCurrentRoom(), getCurrentRoom().getSouth())) {
                        getCurrentRoom().changePearsonStatus(false);
                        setCurrentRoom(getCurrentRoom().getSouth());
                        move = true;
                    } else {
                        Engine2.appendToScreenEngine("Sembra che la porta sia chiusa, percaso ti ritrovi qualche chiave nell'inventario?");
                    }
                } else {
                    noroom = true;
                }
            } else if (p.getCommand().getType() == CommandType.EAST) {
                if (getCurrentRoom().getEast() != null) {
                    if (controller.doorController(getCurrentRoom(), getCurrentRoom().getEast())) {
                        getCurrentRoom().changePearsonStatus(false);
                        setCurrentRoom(getCurrentRoom().getEast());
                        move = true;
                    } else {
                        Engine2.appendToScreenEngine("Sembra che la porta sia chiusa, percaso ti ritrovi qualche chiave nell'inventario?");
                    }
                } else {
                    noroom = true;
                }
            } else if (p.getCommand().getType() == CommandType.WEST) {
                if (getCurrentRoom().getWest() != null) {
                    if (controller.doorController(getCurrentRoom(), getCurrentRoom().getWest())) {
                        getCurrentRoom().changePearsonStatus(false);
                        setCurrentRoom(getCurrentRoom().getWest());
                        move = true;
                    } else {
                        Engine2.appendToScreenEngine("Sembra che la porta sia chiusa, percaso ti ritrovi qualche chiave nell'inventario?");
                    }
                } else { //TODO: rivedere le porte chiuse
                    noroom = true;
                }
            } else if (p.getCommand().getType() == CommandType.COME_UP) {
                if (getCurrentRoom().getComeUp() != null) {
                    if (controller.doorController(getCurrentRoom(), getCurrentRoom().getComeUp())) {
                        getCurrentRoom().changePearsonStatus(false);
                        setCurrentRoom(getCurrentRoom().getComeUp());
                        Engine2.appendToScreenEngine("Sei salito al primo piano.\n");
                        move = true;
                    } else {
                        Engine2.appendToScreenEngine("Sembra che la porta sia chiusa, percaso ti ritrovi qualche chiave nell'inventario?");
                    }
                } else {
                    noroom = true;
                }
            } else if (p.getCommand().getType() == CommandType.GO_DOWN) {
                if (getCurrentRoom().getGoDown() != null) {
                    if (controller.doorController(getCurrentRoom(), getCurrentRoom().getGoDown())) {
                        getCurrentRoom().changePearsonStatus(false);
                        setCurrentRoom(getCurrentRoom().getGoDown());
                        Engine2.appendToScreenEngine("Sei sceso al piano terra.\n");
                        move = true;
                    } else {
                        Engine2.appendToScreenEngine("Sembra che la porta sia chiusa, percaso ti ritrovi qualche chiave nell'inventario?");
                    }
                } else {
                    noroom = true;
                }
            } else if (p.getCommand().getType() == CommandType.INVENTORY) {
                if(!getInventory().isEmpty()){
                    Engine2.appendToScreenEngine("Nel tuo inventario ci sono:");
                for (ObjectAdv o : getInventory()) {
                    Engine2.appendToScreenEngine(o.getName() + ": " + o.getDescription());
                }
                }else{
                    Engine2.appendToScreenEngine("Non ha alcun oggetto nel tuo inventario");
                }
            } else if (p.getCommand().getType() == CommandType.LOOK_AT) {
                if (p.getObject() != null) {
                    Engine2.appendToScreenEngine(p.getObject().getDescription());
                    if(p.getObject() instanceof ObjectAdvContainer){
                        ObjectAdvContainer c = (ObjectAdvContainer) p.getObject();
                        c.showObjectContained();
                    }     
                } else if (getCurrentRoom().getLook() != null || getCurrentRoom().getObjects().isEmpty() == false) {
                    if (getCurrentRoom().getLook() != null) {
                        Engine2.appendToScreenEngine(getCurrentRoom().getLook());
                    }
                    if (!getCurrentRoom().getObjects().isEmpty()) {
                        Engine2.appendToScreenEngine("Nella stanza vedi le seguenti cose: ");
                        for (ObjectAdv  o : getCurrentRoom().getObjects()) {
                            Engine2.appendToScreenEngine(o.getName());
                        }
                    }
                } else {
                    Engine2.appendToScreenEngine("Non c'è nulla di rillevante qui.");
                }
            } else if (p.getCommand().getType() == CommandType.PICK_UP) {
                if (p.getObject() != null) {
                    if (p.getObject().isPickupable()) {
                        getInventory().add(p.getObject());
                        getCurrentRoom().getObjects().remove(p.getObject());
                        Engine2.appendToScreenEngine("Hai raccolto: " + p.getObject().getName() + " - " + p.getObject().getDescription());
                    } else {
                        Engine2.appendToScreenEngine("Non puoi raccogliere questo oggetto.");
                    }
                } else {
                    Engine2.appendToScreenEngine("Non c'è niente da raccogliere qui.");
                }
            } else if (p.getCommand().getType() == CommandType.OPEN) {
                /*TODO: ATTENZIONE: quando un oggetto contenitore viene aperto, tutti gli oggetti contenuti
                * vengongo inseriti nella stanza o nell'inventario a seconda di dove si trova l'oggetto contenitore.
                * Potrebbe non esssere la soluzione ottimale.
                 */
                //TODO: fare la prova ad aprire un oggetto contenitore tipo scaffale in ripostiglio
                if (p.getObject() == null && p.getInvObject() == null) {
                    Engine2.appendToScreenEngine("Non c'è niente da aprire qui.");
                } else {
                    if (p.getObject() != null) {
                        if (p.getObject().isOpenable() && p.getObject().isOpen() == false) {
                            p.getObject().setOpen(true);
                            if (p.getObject() instanceof ObjectAdvContainer) {
                                Engine2.appendToScreenEngine("Hai aperto: " + p.getObject().getName());
                                ObjectAdvContainer c = (ObjectAdvContainer) p.getObject();
                                getCurrentRoom().getObjects().addAll(c.getList());
                                c.showObjectContained();
                            } else {
                                Engine2.appendToScreenEngine("Hai aperto: " + p.getObject().getName());
                            }
                        } else {
                            Engine2.appendToScreenEngine("Non puoi aprire questo oggetto.");
                        }
                    }
                    if (p.getInvObject() != null) {
                        p.getInvObject().setOpen(true);
                        if (p.getInvObject().isOpenable() && p.getInvObject().isOpen() == false) {
                            p.getInvObject().setOpen(true);
                            if (p.getInvObject() instanceof ObjectAdvContainer) {
                                ObjectAdvContainer c = (ObjectAdvContainer) p.getInvObject();
                                getCurrentRoom().getObjects().addAll(c.getList());
                                c.showObjectContained();   
                            }
                            Engine2.appendToScreenEngine("Hai aperto nel tuo inventario: " + p.getInvObject().getName());
                        } else {
                            Engine2.appendToScreenEngine("Non puoi aprire questo oggetto.");
                        }
                    }
                }
            } else if (p.getCommand().getType() == CommandType.PUSH) {
                if (p.getObject() != null && p.getObject().isPushable()) {
                    Engine2.appendToScreenEngine("Hai premuto: " + p.getObject().getName());
                } else if (p.getInvObject() != null && p.getInvObject().isPushable()) {
                    Engine2.appendToScreenEngine("Hai premuto: " + p.getInvObject().getName());
                } else {
                    Engine2.appendToScreenEngine("Non ci sono oggetti che puoi premere qui.");
                }
            } else if (p.getCommand().getType() == CommandType.HURL) {
                if (p.getObject() != null) {
                    if (p.getInvObject() != null) {
                        if (controller.objectHit()) {
                            Engine2.appendToScreenEngine("Hai lanciato: " + p.getInvObject().getName() + " contro " + p.getObject().getName() + " colpendolo");
                            if (p.getObject() instanceof AdvPerson) {
                                AdvPerson person = (AdvPerson) p.getObject();
                                person.setLife(person.getLife() - 1);
                                if (person.getLife() == 0) {
                                    Engine2.appendToScreenEngine("Hai sconfitto " + person.getName() + ".");
                                    getCurrentRoom().getObjects().addAll(person.getList());
                                    person.showObjectContained();
                                    getCurrentRoom().getObjects().remove(person); //remove the person that is dead
                                } else {
                                    Engine2.appendToScreenEngine(person.getName() + " è ferito. Continua così e ti libererai di lui. (Ha ancora " + person.getLife() + " vite)");
                                }
                            } else {
                                if (controller.consequenceOfHurl(p.getObject(), getCurrentRoom(), getInventory())) {
                                    Engine2.appendToScreenEngine("L'oggetto " + p.getObject().getName() + " si è distrutto a seguito dello schianto.");
                                    if (p.getObject() instanceof ObjectAdvContainer) {
                                        ObjectAdvContainer c = (ObjectAdvContainer) p.getObject();
                                        c.showObjectContained();
                                    }
                                } else {
                                    Engine2.appendToScreenEngine("L'oggetto " + p.getObject().getName() + " non si è distrutto a seguito dello schianto.");
                                }
                            }
                        } else {
                            Engine2.appendToScreenEngine("Hai lanciato: " + p.getInvObject().getName() + " contro " + p.getObject().getName() + " ma non lo hai colpito");
                        }
                        if (controller.consequenceOfHurl(p.getObject(), getCurrentRoom(), getInventory())) {
                            Engine2.appendToScreenEngine("L'oggetto " + p.getInvObject().getName() + " si è distrutto a seguito dello schianto.");
                            if (p.getInvObject() instanceof ObjectAdvContainer) {
                                ObjectAdvContainer c = (ObjectAdvContainer) p.getInvObject();
                                c.showObjectContained();
                            }
                        } else {
                            Engine2.appendToScreenEngine("L'oggetto " + p.getInvObject().getName() + " non si è distrutto a seguito dello schianto.");
                        }
                    } else {
                        Engine2.appendToScreenEngine("Tabbaccone, non hai nulla da lanciare");
                        Engine2.appendToScreenEngine("Per poter lanciare un oggetto, lo devi prima prendere.");
                    }
                } else if (p.getInvObject() != null) {
                    Engine2.appendToScreenEngine("Hai lanciato " + p.getInvObject().getName());
                    if (controller.consequenceOfHurl(p.getInvObject(), getCurrentRoom(), getInventory())) {
                        Engine2.appendToScreenEngine("L'oggetto " + p.getInvObject().getName() + " si è distrutto a seguito dello schianto.");
                        if (p.getInvObject() instanceof ObjectAdvContainer) {
                            ObjectAdvContainer c = (ObjectAdvContainer) p.getInvObject();
                            c.showObjectContained();
                        }
                    } else {
                        Engine2.appendToScreenEngine("L'oggetto " + p.getInvObject().getName() + " non si è distrutto a seguito dello schianto.");
                    }
                } else {
                    Engine2.appendToScreenEngine("Non ci sono oggetti che puoi lanciare");
                }
            } else if (p.getCommand().getType() == CommandType.HIT) {
                if (p.getInvObject() != null) {
                    if (p.getObject() != null) {
                        if (controller.objectHit()) {
                            Engine2.appendToScreenEngine("Sei riuscito a colpire " + p.getObject().getName() + " con " + p.getInvObject().getName());
                            if (p.getObject() instanceof AdvPerson) {
                                AdvPerson person = (AdvPerson) p.getObject();
                                person.setLife(person.getLife() - 1);
                                if (person.getLife() == 0) {
                                    Engine2.appendToScreenEngine("Hai sconfitto " + person.getName() + ".");
                                    getCurrentRoom().getObjects().addAll(person.getList());
                                    person.showObjectContained();
                                    getCurrentRoom().getObjects().remove(person); //remove the person that is dead
                                } else {
                                    Engine2.appendToScreenEngine(person.getName() + " è ferito. Continua così e ti libererai di lui. (Ha ancora " + person.getLife() + " vite)");
                                }
                                Engine2.appendToScreenEngine(controller.consequenceOfHit(null, p.getInvObject(), getCurrentRoom(), getInventory()));
                            } else {
                                Engine2.appendToScreenEngine(controller.consequenceOfHit(p.getObject(), p.getInvObject(), getCurrentRoom(), getInventory()));
                            }
                        } else {
                            Engine2.appendToScreenEngine("Non sei riuscito a colpire " + p.getObject().getName() + " con " + p.getInvObject().getName());
                        }
                    } else {
                        Engine2.appendToScreenEngine("Hai colpito l'aria con " + p.getInvObject().getName());
                    }
                } else if (p.getObject() != null) {
                    if (controller.objectHit()) {
                        Engine2.appendToScreenEngine("Non hai preso alcun oggetto, perciò usi le mani. (Ricorda che devi prima prendere un oggetto e poi utilizzarlo)");
                        Engine2.appendToScreenEngine("Sei riuscito a colpire " + p.getObject().getName() + " a mani nude.");
                        if (p.getObject() instanceof AdvPerson) {
                            AdvPerson person = (AdvPerson) p.getObject();
                            person.setLife(person.getLife() - 1);
                            if (person.getLife() == 0) {
                                Engine2.appendToScreenEngine("Hai sconfitto " + person.getName() + ".");
                                getCurrentRoom().getObjects().addAll(person.getList());
                                person.showObjectContained();
                                getCurrentRoom().getObjects().remove(person); //remove the person that is dead
                            } else {
                                Engine2.appendToScreenEngine(person.getName() + " è ferito. Continua così e ti libererai di lui. (Ha ancora " + person.getLife() + " vite)");
                            }
                        } else {
                           Engine2.appendToScreenEngine(controller.consequenceOfHit(p.getObject(), null, getCurrentRoom(), getInventory()));
                        }
                    } else {
                        Engine2.appendToScreenEngine("Non sei riuscito a colpire " + p.getObject().getName());
                    }
                } else {
                    Engine2.appendToScreenEngine("Ma come sei bravo a prendere a pugni l'aria!!");
                }
            } else if (p.getCommand().getType() == CommandType.DRINK) {
                if (p.getObject() == null && p.getInvObject() == null) {
                    Engine2.appendToScreenEngine("Non c'è niente da bere qui.");
                } else {
                    if (p.getObject() != null) {
                        if (p.getObject().isFillable() && p.getObject().getFilled()) {
                            p.getObject().setFilled(false);
                            if (p.getObject() instanceof ObjectAdvContainer) {
                                Engine2.appendToScreenEngine("Hai bevuto: " + p.getObject().getName() + " liberando il contenuto.");
                                ObjectAdvContainer c = (ObjectAdvContainer) p.getObject();
                                getCurrentRoom().getObjects().addAll(c.getList());
                                c.showObjectContained();
                            } else {
                                 Engine2.appendToScreenEngine("Hai bevuto: " + p.getObject().getName());
                            }//TODO: quali sono le conseguenza dell'essere ubriaco?
                        } else {
                            Engine2.appendToScreenEngine("Non puoi bere il contenuto di questo oggetto.");
                        }
                    }
                    if (p.getInvObject() != null) {
                        if (p.getInvObject().isFillable() && p.getInvObject().getFilled()) {
                            p.getInvObject().setFilled(false);
                            if (p.getInvObject() instanceof ObjectAdvContainer) {
                                Engine2.appendToScreenEngine("Hai bevuto: " + p.getObject().getName() + " liberando il contenuto.");
                                ObjectAdvContainer c = (ObjectAdvContainer) p.getInvObject();
                                getInventory().addAll(c.getList());
                                c.showObjectContained();
                            } else {
                                Engine2.appendToScreenEngine("Hai bevuto: " + p.getInvObject().getName());
                                //TODO: se avanza tempo distinguere gli oggetti edibili da quelli non edibili
                            }
                        } else {
                            Engine2.appendToScreenEngine("Non puoi aprire bere il contenuto di questo oggetto.");
                        }
                    }
                }
            }  else if (p.getCommand().getType() == CommandType.EMPTY) {
                if (p.getObject() == null && p.getInvObject() == null) {
                    Engine2.appendToScreenEngine("Non c'è niente da svuotare qui.");
                } else {
                    if (p.getObject() != null) {
                        if (p.getObject().isFillable() && p.getObject().getFilled()) {
                            p.getObject().setFilled(false);
                            if (p.getObject() instanceof ObjectAdvContainer) {
                                Engine2.appendToScreenEngine("Hai svuotato: " + p.getObject().getName() + " liberando il contenuto.");
                                ObjectAdvContainer c = (ObjectAdvContainer) p.getObject();
                                getCurrentRoom().getObjects().addAll(c.getList());
                                c.showObjectContained();
                            } else {
                                Engine2.appendToScreenEngine("Hai svuotato: " + p.getObject().getName());
                            }
                        } else {
                            Engine2.appendToScreenEngine("Non puoi svuotare questo oggetto.");
                        }
                    }
                    if (p.getInvObject() != null) {
                        if (p.getInvObject().isFillable() && p.getInvObject().getFilled()) {
                            p.getInvObject().setFilled(false);
                            if (p.getInvObject() instanceof ObjectAdvContainer) {
                                Engine2.appendToScreenEngine("Hai svuotato: " + p.getObject().getName() + " liberando il contenuto.");
                                ObjectAdvContainer c = (ObjectAdvContainer) p.getInvObject();
                                getInventory().addAll(c.getList());
                                c.showObjectContained();
                            } else {
                                Engine2.appendToScreenEngine("Hai svuotato: " + p.getInvObject().getName());
                            }
                        } else {
                            Engine2.appendToScreenEngine("Non puoi svuotare questo oggetto.");
                        }
                    }
                }
            } else if (p.getCommand().getType() == CommandType.PLAY) {
                Engine2.appendToScreenEngine(" \n benvenuto nel gioco");
            }
            if (noroom) {
                Engine2.appendToScreenEngine("Da quella parte non si può andare c'è un muro!\nNon hai ancora acquisito i poteri per oltrepassare i muri...");
            } else if (move) {
                Engine2.appendToScreenEngine(getCurrentRoom().getName());
                Engine2.appendToScreenEngine("================================================");
                Engine2.appendToScreenEngine(getCurrentRoom().getDescription());
                getCurrentRoom().changePearsonStatus(true);
                getCurrentRoom().startInitiativePearsons();
            }
        }
    }

    private void end() {
        Engine2.appendToScreenEngine("Premi il pulsante del giocattolo e in seguito ad una forte esplosione la tua casa prende fuoco...\ntu e tuoi famigliari cercate invano di salvarvi e venite avvolti dalle fiamme...\nè stata una morte CALOROSA...addio!");
        System.exit(0);
    }
}
