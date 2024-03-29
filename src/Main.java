import controller.UnderWriterController;
import controller.VehicleController;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UnderWriterController unwc = new UnderWriterController();
        VehicleController vc = new VehicleController();
        Scanner sc = new Scanner(System.in);

        int adminId = 1234;
        String adminPassword = "1234";

        System.out.println("Press 1 for Admin");
        System.out.println("Press 2 for UnderWriter");

        int n = sc.nextInt();

        switch (n) {

            case 1:
                int id;
                String pass;
                System.out.println("Enter the Admin Id");
                id = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter the Admin password");
                pass = sc.nextLine();

                if (id == adminId && adminPassword.equals(pass)) {

                    System.out.println("Press 1 to Register UnderWriter");
                    System.out.println("Press 2 to Search UnderWriter by Id");
                    System.out.println("Press 3 to Delete UnderWriter by Id");
                    System.out.println("Press 4 to Update  UnderWriter password by Id");
                    System.out.println("Press 5 to View all registered UnderWriter");
                    System.out.println("Press 6 to View all vehicles registered under UnderWriter ");

                    int choice;
                    choice = sc.nextInt();

                    switch (choice) {
                        case 1:
                            System.out.println("Register UnderWriter");
                            int uwId;
                            String name;
                            String dob;
                            String doj;
                            String password;

                            System.out.println("Enter the UnderWriterId");
                            uwId = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Enter the name");
                            name = sc.nextLine();
                            System.out.println("Enter the Date of birth");
                            dob = sc.nextLine();
                            System.out.println("Enter the Date of joining");
                            doj = sc.nextLine();
                            System.out.println("Enter the password");
                            password = sc.nextLine();

                            unwc.createUnderWriter(uwId, name, dob, doj, password);
                            break;

                        case 2:
                            System.out.println("Search Underwriter by Id");
                            System.out.println("Enter the UnderWriter Id to be searched");
                            int uwId1 = sc.nextInt();
                            unwc.searchUnderWriter(uwId1);
                            break;

                        case 3:
                            System.out.println("Delete UnderWriter by Id");
                            System.out.println("Enter the UnderWriter Id to be deleted");
                            int uwId2 = sc.nextInt();
                            unwc.deleteUnderWriter(uwId2);
                            break;

                        case 4:
                            System.out.println("Update UnderWriter password by Id");
                            System.out.println("Enter the UnderWriter Id to be updated");
                            int uwId3 = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Enter the old password");
                            String password1 = sc.nextLine();
                            System.out.println("Enter the new password");
                            String password2 = sc.nextLine();
                            unwc.updateUnderWriter(uwId3, password1, password2);
                            break;

                        case 5:
                            System.out.println("View all registered UnderWriter");
                            unwc.viewAllUnderWriter();
                            break;
                    }


                } else {
                    System.out.println("Invalid Admin Id or Password");
                    break;
                }
                break;

            case 2:
                System.out.println("Enter the UnderWriter Id");
                int uwId = sc.nextInt();
                System.out.println("Enter the UnderWriter password");
                String password = sc.next();

                boolean a = unwc.validate(uwId, password);

                if (a) {

                    System.out.println("Press 1 to create new vehicle insurance policy");
                    System.out.println("Press 2 to renew vehicle insurance policy");
                    System.out.println("Press 3 to change vehicle insurance policy type");
                    System.out.println("Press 4 to view all vehicle insurance policy");
                    int ch = sc.nextInt();

                    switch (ch) {
                        case 1:

                            System.out.println("Enter the vehicle number");
                            int vno = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Enter the vehicle type");
                            String vtype = sc.nextLine();
                            System.out.println("Enter the customer name");
                            String cname = sc.nextLine();
                            System.out.println("Enter the engine number");
                            int engno = sc.nextInt();
                            System.out.println("Enter the chasis number");
                            int chno = sc.nextInt();
                            System.out.println("Enter the phone number");
                            long phno = sc.nextLong();
                            sc.nextLine();
                            System.out.println("Enter the insurance type");
                            String itype = sc.nextLine();
                            System.out.println("Enter the premium amount");
                            int preamo = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Enter the from date");
                            String fd = sc.nextLine();
                            System.out.println("Enter the to date");
                            String td = sc.nextLine();
                            System.out.println("Enter the UnderWriter Id");
                            int uid = sc.nextInt();
                            vc.register( vno, vtype, cname, engno, chno, phno, itype, preamo, fd, td, uid);
                            break;

                        case 2:
                            System.out.println("Enter the policy number");
                            int pno1 = sc.nextInt();
                            System.out.println("Enter the premium amount");
                            int preamo1 = sc.nextInt();
                            vc.renewPolicy(pno1, preamo1);
                            break;

                        case 3:
                            System.out.println("Enter the Policy Id ");
                            int pno = sc.nextInt();
                            vc.changeType(pno);
                            break;

                        case 4:
                            System.out.println("Enter the UnderWriter Id");
                            int uid1 = sc.nextInt();
                            vc.viewAll(uid1);

                    }


                } else {
                    System.out.println("Invalid UnderWriter Id or Password");
                }
                break;


        }


    }
}