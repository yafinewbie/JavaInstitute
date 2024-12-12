package main;


import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import models.Report;
import models.Siswa;

public class Main extends Application{
	//universal
	MenuBar menuBar;
	Menu manajemenJadwal, manajemenPeserta, inputTutor, report;
	
	
	Scene sceneLogo, sceneLogin,sceneManajemenPeserta, sceneInputPeserta, sceneUpdatePeserta, sceneTutor, sceneJadwalBaru, sceneUpdateJadwal, sceneReport;
	BorderPane bpLogo, bpManajemenPeserta, bpInputPeserta, bpUpdatePeserta, bpTutor, bpJadwalBaru, bpUpdateJadwal, bpReport;
	GridPane gpLogin, gpInputPeserta, gpUpdatePeserta, gpTutor, gpJadwalBaru, gpUpdateJadwal;
	ScrollPane spManajemenPeserta, spReport;
	VBox vboxReport, vboxManajemenPeserta;
	
	TableView<Report> reportTable;
	TableView<Siswa> pesertaTable;

	
	private void initializeUniversal() {
		
		bpLogo = new BorderPane();
		bpLogo.setStyle("-fx-border-color: pink; -fx-border-width: 5;");

		gpLogin = new GridPane();
		gpLogin.setStyle("-fx-padding: 20; -fx-alignment: center;");
		
		bpManajemenPeserta = new BorderPane();
		vboxManajemenPeserta = new VBox();		
		
		gpInputPeserta = new GridPane();
		bpInputPeserta = new BorderPane();
		
		gpUpdatePeserta = new GridPane();
	    bpUpdatePeserta = new BorderPane();

		bpTutor = new BorderPane();
		gpTutor = new GridPane();
		
		bpJadwalBaru = new BorderPane();
		gpJadwalBaru = new GridPane();
		
		gpUpdateJadwal = new GridPane();
	    bpUpdateJadwal = new BorderPane();
	    
	    bpReport = new BorderPane();
	    vboxReport = new VBox(10);
	    
	    bpLogo.setStyle("-fx-font-family: 'Arial';");
	    gpLogin.setStyle("-fx-font-family: 'Arial';");
	    bpInputPeserta.setStyle("-fx-font-family: 'Arial';");
	    bpUpdatePeserta.setStyle("-fx-font-family: 'Arial';");
	    bpTutor.setStyle("-fx-font-family: 'Arial';");
	    bpJadwalBaru.setStyle("-fx-font-family: 'Arial';");
	    bpUpdateJadwal.setStyle("-fx-font-family: 'Arial';");
	    bpReport.setStyle("-fx-font-family: 'Arial';");
	    bpManajemenPeserta.setStyle("-fx-font-family: 'Arial';");
	    
	}
	
	private void initializeLogo() {
		Image imageLogo = new Image("LogoJavaInstitute.png");
		ImageView imageView = new ImageView(imageLogo);
		imageView.setFitWidth(300); 
	    imageView.setFitHeight(300);
		
		Label kursus = new Label("Kursus");
		kursus.setFont(Font.font(20));
		
		Label javaText = new Label("Java");
		javaText.setFont(Font.font(20));
		
		HBox textBox = new HBox(10);
	    textBox.getChildren().addAll(kursus,javaText);
	    textBox.setStyle("-fx-alignment: center; -fx-padding: 40;");
	    
		BorderPane.setAlignment(imageView,Pos.CENTER);

	    bpLogo.setCenter(imageView);
	    bpLogo.setBottom(textBox);
	    bpLogo.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));

	}
	
	private void initializeLogin() {		
		Button login = new Button("login");
		
		Label logoText = new Label("Java Institute");
		logoText.setFont(Font.font(24));

		Label email = new Label("Email");
		email.setFont(Font.font(16));

		Label password = new Label("Password");
		password.setFont(Font.font(16));

		
		TextField txtEmail= new TextField();
		PasswordField txtPass = new PasswordField();

        
        gpLogin.add(logoText, 0, 0, 2, 1);
        gpLogin.add(email, 0, 1);
        gpLogin.add(txtEmail, 1, 1);
        gpLogin.add(password, 0, 2);
        gpLogin.add(txtPass, 1, 2);
        gpLogin.add(login, 1, 3);

        gpLogin.setVgap(20);
        gpLogin.setHgap(20);

        GridPane.setHalignment(logoText, HPos.CENTER);

        gpLogin.setAlignment(Pos.CENTER);
        
        gpLogin.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        
        //jangan lupa bikin event handler kalau error wkkwkw
	}

	private MenuBar createMenuBar() {
	    MenuBar menuBar = new MenuBar();
	    Menu manajemenJadwal = new Menu("Manajemen Jadwal");
	    Menu manajemenPeserta = new Menu("Manajemen Peserta");
	    Menu inputTutor = new Menu("Input Tutor");
	    Menu report = new Menu("Report");

	    menuBar.getMenus().addAll(manajemenJadwal, manajemenPeserta, inputTutor, report);
	    return menuBar;
	}
	
	private void initializeInputPeserta() {

		Button submitPeserta;
		Label judulInputPeserta, namaPeserta, tglLhrPeserta, emailPeserta, noTlpnPeserta, level;
		TextField txtNamaPeserta, txtEmailPeserta, txtnoTlpnPeserta;
		DatePicker pickTglLhrPeserta;
		ComboBox<String> levelList;
		
		submitPeserta = new Button("Submit");
		
		judulInputPeserta = new Label("Input Peserta");
		judulInputPeserta.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-padding: 10 0 20 0;");
		
		namaPeserta = new Label("Nama");
		tglLhrPeserta= new Label("Tanggal Lahir");
		emailPeserta= new Label("Email");
		noTlpnPeserta = new Label("No Telepon");
		level = new Label("Level");
		
		
		txtNamaPeserta = new TextField();
		txtEmailPeserta = new TextField();
		txtnoTlpnPeserta = new TextField();
	
		pickTglLhrPeserta = new DatePicker();
		
		levelList = new ComboBox<>();
		levelList.getItems().add("Beginner");
		levelList.getItems().add("Intermediate");
		levelList.getItems().add("Advance");
		levelList.getSelectionModel().selectFirst();
		
		
		gpInputPeserta.add(judulInputPeserta, 0, 0, 2, 1);
		gpInputPeserta.add(namaPeserta, 0, 1);
		gpInputPeserta.add(tglLhrPeserta, 0, 2);
		gpInputPeserta.add(emailPeserta, 0, 3);
		gpInputPeserta.add(noTlpnPeserta, 0, 4);
		gpInputPeserta.add(level, 0, 5);

		
		gpInputPeserta.add(txtNamaPeserta, 1, 1);
		gpInputPeserta.add(pickTglLhrPeserta, 1, 2);
		gpInputPeserta.add(txtEmailPeserta, 1, 3);
		gpInputPeserta.add(txtnoTlpnPeserta, 1, 4);
		gpInputPeserta.add(levelList, 1, 5);

		
		gpInputPeserta.add(submitPeserta, 0, 6);
		
		gpInputPeserta.setHgap(5);
		gpInputPeserta.setVgap(5);
		
		gpInputPeserta.setPadding(new Insets(10));
		
		bpInputPeserta.setCenter(gpInputPeserta);
		
		bpInputPeserta.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		
	}
	
	private void initializeupdatePeserta() {
		//ini masih raw banget, gak konek apa2. variabelnya berdiri sendiri	
		Button submitUpdatePeserta;
	    Label judulUpdatePeserta, namaPeserta, tglLhrPeserta, emailPeserta, noTlpnPeserta, level;
	    TextField txtNamaPeserta, txtEmailPeserta, txtnoTlpnPeserta;
	    DatePicker pickTglLhrPeserta;
	    ComboBox<String> levelList;

	    // Button untuk submit
	    submitUpdatePeserta = new Button("Update");

	    // Judul
	    judulUpdatePeserta = new Label("Update Peserta");
	    judulUpdatePeserta.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-padding: 10 0 20 0;");

	    // Labels
	    namaPeserta = new Label("Nama");
	    tglLhrPeserta = new Label("Tanggal Lahir");
	    emailPeserta = new Label("Email");
	    noTlpnPeserta = new Label("No Telepon");
	    level = new Label("Level");

	    // Input Fields
	    txtNamaPeserta = new TextField("John Doe"); // Contoh data sebelumnya
	    txtNamaPeserta.setEditable(false);         // Tidak bisa diedit
	    txtNamaPeserta.setOpacity(0.5);            // Kurangi opacity agar terlihat disabled

	    txtEmailPeserta = new TextField("johndoe@example.com"); // Contoh data sebelumnya
	    txtEmailPeserta.setEditable(false);                     // Tidak bisa diedit
	    txtEmailPeserta.setOpacity(0.5);                        // Kurangi opacity agar terlihat disabled

	    txtnoTlpnPeserta = new TextField("123456789"); // Contoh data sebelumnya
	    txtnoTlpnPeserta.setEditable(false);          // Tidak bisa diedit
	    txtnoTlpnPeserta.setOpacity(0.5);             // Kurangi opacity agar terlihat disabled

	    pickTglLhrPeserta = new DatePicker();         // Contoh data sebelumnya
	    pickTglLhrPeserta.setDisable(true);           // Tidak bisa diedit
	    pickTglLhrPeserta.setOpacity(0.5);            // Kurangi opacity agar terlihat disabled

	    // Dropdown untuk level
	    levelList = new ComboBox<>();
	    levelList.getItems().add("Beginner");
	    levelList.getItems().add("Intermediate");
	    levelList.getItems().add("Advance");
	    levelList.getSelectionModel().select("Intermediate"); // Contoh level sebelumnya
	    levelList.setDisable(false);                          // Tetap bisa diganti

	    // Layout menggunakan GridPane
	    gpUpdatePeserta.add(judulUpdatePeserta, 0, 0, 2, 1);
	    gpUpdatePeserta.add(namaPeserta, 0, 1);
	    gpUpdatePeserta.add(tglLhrPeserta, 0, 2);
	    gpUpdatePeserta.add(emailPeserta, 0, 3);
	    gpUpdatePeserta.add(noTlpnPeserta, 0, 4);
	    gpUpdatePeserta.add(level, 0, 5);

	    gpUpdatePeserta.add(txtNamaPeserta, 1, 1);
	    gpUpdatePeserta.add(pickTglLhrPeserta, 1, 2);
	    gpUpdatePeserta.add(txtEmailPeserta, 1, 3);
	    gpUpdatePeserta.add(txtnoTlpnPeserta, 1, 4);
	    gpUpdatePeserta.add(levelList, 1, 5);

	    gpUpdatePeserta.add(submitUpdatePeserta, 0, 6);

	    // Set spacing dan padding
	    gpUpdatePeserta.setHgap(5);
	    gpUpdatePeserta.setVgap(5);
	    gpUpdatePeserta.setPadding(new Insets(10));

	    // Set ke BorderPane
	    bpUpdatePeserta.setCenter(gpUpdatePeserta);

	    // Background warna putih
	    bpUpdatePeserta.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
	}
	
	private void initializeManajemenPeserta() {
		Label judulManajemenPeserta, listPeserta;
		Button inputPeserta, updatePeserta;
		pesertaTable = new TableView<>();

		judulManajemenPeserta = new Label("Manajemen Peserta");
		judulManajemenPeserta.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-padding: 10 0 20 0;");

		//ini kalau kepencet ke scene input peserta
		inputPeserta = new Button("Tambah Peserta");
		
		//ini kalau kepencet ke scene update peserta, tapi harus dipencet dulu mana peserta yang mau diupdate dari tabel.
		updatePeserta = new Button("Update Peserta");
		
	    listPeserta = new Label("List Peserta");

	  	TableColumn<Siswa, String> namaPeserta = new TableColumn<> ("Nama Peserta");
	  	TableColumn<Siswa, String> email = new TableColumn<> ("Email");
	  	TableColumn<Siswa, String> noTlpnPeserta = new TableColumn<> ("No. HP");
	  	TableColumn<Siswa, String> level = new TableColumn<> ("Level");
	  
	  	namaPeserta.setCellValueFactory(new PropertyValueFactory<Siswa, String>("Nama Peserta"));
	  	email.setCellValueFactory(new PropertyValueFactory<Siswa, String>("Email"));
	  	noTlpnPeserta.setCellValueFactory(new PropertyValueFactory<Siswa, String>("No. HP"));
	  	level.setCellValueFactory(new PropertyValueFactory<Siswa, String>("Level"));
	  	
	  	pesertaTable.getColumns().add(namaPeserta);
	  	pesertaTable.getColumns().add(email);
	  	pesertaTable.getColumns().add(noTlpnPeserta);
	  	pesertaTable.getColumns().add(level);
	  	
	  	//ini supaya lebar columnya proporsional
	  	namaPeserta.prefWidthProperty().bind(pesertaTable.widthProperty().multiply(0.25));
	    email.prefWidthProperty().bind(pesertaTable.widthProperty().multiply(0.25));
	    noTlpnPeserta.prefWidthProperty().bind(pesertaTable.widthProperty().multiply(0.25));
	    level.prefWidthProperty().bind(pesertaTable.widthProperty().multiply(0.25));
	  
	    spManajemenPeserta = new ScrollPane(pesertaTable);
	    spManajemenPeserta.setFitToWidth(true);
	    spManajemenPeserta.setFitToHeight(true);
	    spManajemenPeserta.setPrefHeight(300);
	    
	    vboxManajemenPeserta.setPadding(new Insets(10));
	    vboxManajemenPeserta.setSpacing(10);
	    vboxManajemenPeserta.getChildren().addAll(judulManajemenPeserta, inputPeserta, updatePeserta, listPeserta, spManajemenPeserta);
	    
	    bpManajemenPeserta.setTop(createMenuBar());
	    bpManajemenPeserta.setCenter(vboxManajemenPeserta);
	    
	    
	    bpManajemenPeserta.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
	}
	
	private void initializeTutor() {
		Button submitTutor;
		Label judulInputTutor, namaTutor, tglLhrTutor, emailTutor, noTlpnTutor;
		TextField txtNamaTutor, txtEmailTutor, txtnoTlpnTutor;
		DatePicker pickTglLhrTutor;
		
		submitTutor = new Button("Submit");
		
		judulInputTutor = new Label("Input Tutor");
		judulInputTutor.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-padding: 10 0 20 0;");
		
		namaTutor = new Label("Nama");
		tglLhrTutor= new Label("Tanggal Lahir");
		emailTutor = new Label("Email");
		noTlpnTutor = new Label("No Telepon");
		
		
		txtNamaTutor = new TextField();
		txtEmailTutor = new TextField();
		txtnoTlpnTutor = new TextField();
	
		
		pickTglLhrTutor = new DatePicker();
		
		gpTutor.add(judulInputTutor, 0, 0, 2, 1);
		gpTutor.add(namaTutor, 0, 1);
		gpTutor.add(tglLhrTutor, 0, 2);
		gpTutor.add(emailTutor, 0, 3);
		gpTutor.add(noTlpnTutor, 0, 4);

		
		gpTutor.add(txtNamaTutor, 1, 1);
		gpTutor.add(pickTglLhrTutor, 1, 2);
		gpTutor.add(txtEmailTutor, 1, 3);
		gpTutor.add(txtnoTlpnTutor, 1, 4);

		
		gpTutor.add(submitTutor, 0, 5);
		
		gpTutor.setHgap(5);
		gpTutor.setVgap(5);
		
		gpTutor.setPadding(new Insets(10));
		
		bpTutor.setTop(createMenuBar());
		bpTutor.setCenter(gpTutor);
		
		bpTutor.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		
	}
	
	private void initializeJadwalBaru() {
		Button submitJadwalBaru;
		Label judulJadwalBaru, hari, level, jam, tutor;
		TextField txtHari, txtJam;
		ComboBox<String> tutorList, levelList;
		
		submitJadwalBaru= new Button("Submit");

		judulJadwalBaru = new Label("Jadwal Baru");
		judulJadwalBaru.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-padding: 10 0 20 0;");
		
		hari = new Label("Hari");
		level = new Label("Level");
		jam = new Label("Jam");
		tutor = new Label("Tutor");
		
		
		txtHari= new TextField();
		txtJam = new TextField();
		
		tutorList = new ComboBox<>();
		levelList = new ComboBox<>();
		
		//sementara ini dulu buat isi combobox wkwk
		tutorList.getItems().add("Ka Yafi");
		tutorList.getItems().add("Ka Firman");
		tutorList.getItems().add("Ka Beby");
		tutorList.getSelectionModel().selectFirst();
		
		levelList.getItems().add("Beginner");
		levelList.getItems().add("Intermediate");
		levelList.getItems().add("Advance");
		levelList.getSelectionModel().selectFirst();
	
		gpJadwalBaru.add(judulJadwalBaru, 0, 0, 2, 1);
		gpJadwalBaru.add(hari, 0, 1);
		gpJadwalBaru.add(level, 0, 2);
		gpJadwalBaru.add(jam, 0, 3);
		gpJadwalBaru.add(tutor, 0, 4);

		
		gpJadwalBaru.add(txtHari, 1, 1);
		gpJadwalBaru.add(levelList, 1, 2);
		gpJadwalBaru.add(txtJam, 1, 3);
		gpJadwalBaru.add(tutorList, 1, 4);

		
		gpJadwalBaru.add(submitJadwalBaru, 0, 5);
		
		gpJadwalBaru.setHgap(5);
		gpJadwalBaru.setVgap(5);
		
		gpJadwalBaru.setPadding(new Insets(10));
		
		bpJadwalBaru.setTop(createMenuBar());
		bpJadwalBaru.setCenter(gpJadwalBaru);
		
		bpJadwalBaru.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		
		
	}
	
	private void initializeUpdateJadwal() {
		Button submitUpdateJadwal;
		Label judulUpdateJadwal, hariUpdate, levelUpdate, jamUpdate, tutorUpdate;
		TextField txtHariUpdate, txtJamUpdate;
		ComboBox<String> tutorListUpdate, levelListUpdate;
		
	    submitUpdateJadwal = new Button("Update");

	    judulUpdateJadwal = new Label("Update Jadwal");
	    judulUpdateJadwal.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-padding: 10 0 20 0;");

	    hariUpdate = new Label("Hari");
	    levelUpdate = new Label("Level");
	    jamUpdate = new Label("Jam");
	    tutorUpdate = new Label("Tutor");

	    txtHariUpdate = new TextField();
	    txtHariUpdate.setDisable(true); // Non-editable
	    txtHariUpdate.setStyle("-fx-opacity: 1;"); // Ensure it looks like a disabled field

	    txtJamUpdate = new TextField();
	    txtJamUpdate.setDisable(true); // Non-editable
	    txtJamUpdate.setStyle("-fx-opacity: 1;");

	    levelListUpdate = new ComboBox<>();
	    levelListUpdate.getItems().addAll("Beginner", "Intermediate", "Advance");
	    levelListUpdate.getSelectionModel().selectFirst();
	    levelListUpdate.setDisable(true); // Non-editable

	    tutorListUpdate = new ComboBox<>();
	    tutorListUpdate.getItems().addAll("Ka Yafi", "Ka Firman", "Ka Beby");
	    tutorListUpdate.getSelectionModel().selectFirst();
	    
	    gpUpdateJadwal.add(judulUpdateJadwal, 0, 0, 2, 1);
	    gpUpdateJadwal.add(hariUpdate, 0, 1);
	    gpUpdateJadwal.add(levelUpdate, 0, 2);
	    gpUpdateJadwal.add(jamUpdate, 0, 3);
	    gpUpdateJadwal.add(tutorUpdate, 0, 4);

	    gpUpdateJadwal.add(txtHariUpdate, 1, 1);
	    gpUpdateJadwal.add(levelListUpdate, 1, 2);
	    gpUpdateJadwal.add(txtJamUpdate, 1, 3);
	    gpUpdateJadwal.add(tutorListUpdate, 1, 4);

	    gpUpdateJadwal.add(submitUpdateJadwal, 0, 5);

	    gpUpdateJadwal.setHgap(5);
	    gpUpdateJadwal.setVgap(5);

	    gpUpdateJadwal.setPadding(new Insets(10));
	    
	    bpUpdateJadwal.setTop(createMenuBar());
	    bpUpdateJadwal.setCenter(gpUpdateJadwal);
	    
	    bpUpdateJadwal.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
	}
	
	private void initializeReport() {
		
		Label judulReport, bulanReport;
		ComboBox<Integer> bulanList;
		reportTable = new TableView<>();

		judulReport = new Label("Laporan Kehadiran Tutor");
		judulReport.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-padding: 10 0 20 0;");

	    bulanReport = new Label("Pilih Bulan");

	    bulanList= new ComboBox<>();
	    bulanList.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12);
	    bulanList.getSelectionModel().selectFirst();
	    
	  	TableColumn<Report, String> namaTutor= new TableColumn<>("Nama Tutor");
	  	TableColumn<Report, Integer> jumlah = new TableColumn<>("Jumlah Kehadiran");	  	
	  	
	  	namaTutor.setCellValueFactory(new PropertyValueFactory<Report, String>("Nama Tutor"));
	  	jumlah.setCellValueFactory(new PropertyValueFactory<Report, Integer>("jumlah"));
	  	
	  	reportTable.getColumns().add(namaTutor);
	  	reportTable.getColumns().add(jumlah);
	  	
	  	//ini supaya lebar columnya proporsional
	  	namaTutor.prefWidthProperty().bind(reportTable.widthProperty().multiply(0.5));
	    jumlah.prefWidthProperty().bind(reportTable.widthProperty().multiply(0.5));
	  
	    spReport = new ScrollPane(reportTable);
	    spReport.setFitToWidth(true);
	    spReport.setFitToHeight(true);
	    spReport.setPrefHeight(300);
	    
	    vboxReport.setPadding(new Insets(10));
	    vboxReport.getChildren().addAll(judulReport, bulanReport, bulanList, spReport);
	    
	    bpReport.setTop(createMenuBar());
	    bpReport.setCenter(vboxReport);
	    
	    
	    bpReport.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		initializeUniversal();
		initializeLogo();
		initializeLogin();
		initializeManajemenPeserta();
		initializeInputPeserta();
		initializeupdatePeserta();
		initializeTutor();
		initializeJadwalBaru();
		initializeUpdateJadwal();
		initializeReport();
		
		
		sceneLogo = new Scene(bpLogo, 600, 400);
		sceneLogin = new Scene(gpLogin, 600, 300);
		sceneManajemenPeserta = new Scene(bpManajemenPeserta, 900, 300);
		sceneInputPeserta = new Scene (bpInputPeserta, 600, 300);
		sceneUpdatePeserta = new Scene(bpUpdatePeserta, 600, 300);
		sceneTutor = new Scene(bpTutor, 600, 300);
		sceneJadwalBaru = new Scene(bpJadwalBaru, 600, 300);
		sceneUpdateJadwal = new Scene(bpUpdateJadwal, 600, 300);
		sceneReport = new Scene(bpReport, 900, 500);
		
		
		Image icon = new Image("LogoJavaInstitute.png");
		primaryStage.getIcons().add(icon);
		//belum bikin action antar scene
		primaryStage.setTitle("Java Institute");
		primaryStage.setScene(sceneManajemenPeserta);
		primaryStage.show();
		
		
	}

}
