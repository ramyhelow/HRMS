/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.MainControllers;

import Controller.SubControllers.AddEmployeeController;
import Controller.SubControllers.DeleteEmployeeController;
import Controller.SubControllers.UpdateEmployeeController;
import Model.DBFacade;
import View.Frames.AppFrame;
import View.Frames.FrameFactory;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

/**
 *
 * @author aburom
 */
public class MainController {

    static MainController mainController = null;
    FrameFactory aFactory = new FrameFactory();
    AppFrame mainFrame;
    DBFacade db = DBFacade.getDBFacade();

    private MainController() throws SQLException, ClassNotFoundException {
        mainFrame = aFactory.getFrame("main");
        mainFrame.setLogoutListener(LogoutButtonAction());
        mainFrame.setAddIconListener(AddEmployeeAction());
        mainFrame.setDeleteIconListener(DeleteEmployeeAction());
        mainFrame.setUpdateIconListener(UpdateEmployeeAction());
        fillTable();
        showMainFrame();
    }
    
    public static MainController getMainController() throws SQLException, ClassNotFoundException{
        if(mainController==null){
            mainController=new MainController();
        }
        mainController.showMainFrame();
        mainController.fillTable();
        return mainController;
    }
    
    public void showMainFrame() {
        mainFrame.showFrame();
    }

    public void hideMainFrame() {
        mainFrame.hideFrame();
    }

    public void fillTable() throws SQLException, ClassNotFoundException {
        mainFrame.fillTable(db.getEmployeeData(), db.getEmployeeColumns());
    }

    public MouseListener LogoutButtonAction() {
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainFrame.hideFrame();
                mainFrame.clearFields();
                LoginController.getLoginController();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };
    }

    public MouseListener AddEmployeeAction() {
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AddEmployeeController.getAddEmployeeController();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };
        
    }

    public MouseListener DeleteEmployeeAction() {
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DeleteEmployeeController.getDeleteEmployeeController();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };
        
    }
    
    public MouseListener UpdateEmployeeAction() {
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                UpdateEmployeeController.getUpdateEmployeeController();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };
    }
//    
//    public void setConfirmAddEmployeeButtonListener(ActionListener listener){
//        aFrameFacade.confirmAddEmployeeActionListener(listener);
//    }

}