/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repo.processRepo;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author SWATANTRA
 */
public class processController extends HttpServlet {

    processRepo repo = new processRepo();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String process = request.getParameter("process");
            String miniProcess = request.getParameter("miniProcess");
            try {
                if (process.equals("sales")) {
                    request.setAttribute("process", process);
                    RequestDispatcher view = request.getRequestDispatcher("sales.jsp");
                    view.forward(request, response);
                } else if (process.equals("saleslast")) {
                    ResultSet rs = repo.lastdata();
                    request.setAttribute("result", rs);
                    request.setAttribute("process", process);
                    RequestDispatcher view = request.getRequestDispatcher("sales.jsp");
                    view.forward(request, response);
                } else if (process.equals("Allsales")) {
                    ResultSet rs = repo.getallData();
                    request.setAttribute("result", rs);

                    request.setAttribute("process", process);
                    RequestDispatcher view = request.getRequestDispatcher("sales.jsp");
                    view.forward(request, response);
                } else if (process.equals("EditViewData")) {
                    int rowid = Integer.parseInt(request.getParameter("rowid"));
                    ResultSet rs = repo.EditViewData(rowid);
                    request.setAttribute("result", rs);
                    request.setAttribute("process", process);
                    if (miniProcess.equals("sales")) {
                        RequestDispatcher view = request.getRequestDispatcher("sales.jsp");
                        view.forward(request, response);
                    } else if (miniProcess.equals("purchase")) {
                        RequestDispatcher view = request.getRequestDispatcher("purchase.jsp");
                        view.forward(request, response);
                    }

                } else if (process.equals("salesupdate")) {

                    int userid = Integer.parseInt(request.getParameter("userid"));
                    String username = request.getParameter("name");
                    String email = request.getParameter("email");
                    String phone = request.getParameter("phone");
                    String city = "";
                    if (miniProcess.equals("sales")) {
                        city = "surat";
                    } else if (miniProcess.equals("purchase")) {
                        city = "russia";
                    }
                    String course = request.getParameter("course");
                    int status = repo.updatestudentdetails(username, email, phone, city, course, userid);
                    request.setAttribute("status", status);

                    request.setAttribute("process", process);
                    if (miniProcess.equals("sales")) {
                        RequestDispatcher view = request.getRequestDispatcher("sales.jsp");
                        view.forward(request, response);
                    } else if (miniProcess.equals("purchase")) {
                        RequestDispatcher view = request.getRequestDispatcher("purchase.jsp");
                        view.forward(request, response);
                    }
                } else if (process.equals("AddTransaction")) {
                    String username = request.getParameter("name");
                    String email = request.getParameter("email");
                    String phone = request.getParameter("phone");
                    String city = "";
                    if (miniProcess.equals("sales")) {
                        city = "surat";
                    } else if (miniProcess.equals("purchase")) {
                        city = "russia";
                    }
                    String course = request.getParameter("course");

                    int status = repo.newstudentdetails(username, email, phone, city, course);
                    request.setAttribute("status", status);
                    request.setAttribute("process", process);
                    if (miniProcess.equals("sales")) {
                        RequestDispatcher view = request.getRequestDispatcher("sales.jsp");
                        view.forward(request, response);
                    } else if (miniProcess.equals("purchase")) {
                        RequestDispatcher view = request.getRequestDispatcher("purchase.jsp");
                        view.forward(request, response);
                    }
                } else if (process.equals("deleteSales")) {
                    int userid = Integer.parseInt(request.getParameter("userid"));
                    int status = repo.deletestudentdetail(userid);
                    request.setAttribute("process", process);
                    request.setAttribute("status", status);

                    if (miniProcess.equals("sales")) {
                        RequestDispatcher view = request.getRequestDispatcher("sales.jsp");
                        view.forward(request, response);
                    } else if (miniProcess.equals("purchase")) {
                        RequestDispatcher view = request.getRequestDispatcher("purchase.jsp");
                        view.forward(request, response);
                    }
                } //                -----------------
                else if (process.equals("purchase")) {
                    request.setAttribute("process", process);
                    RequestDispatcher view = request.getRequestDispatcher("purchase.jsp");
                    view.forward(request, response);
                } else if (process.equals("Purchaselast")) {
                    ResultSet rs = repo.lastdataPurchase();
                    request.setAttribute("result", rs);
                    request.setAttribute("process", process);
                    RequestDispatcher view = request.getRequestDispatcher("purchase.jsp");
                    view.forward(request, response);
                } else if (process.equals("AllPurchase")) {
                    ResultSet rs = repo.getallDataPurchase();
                    request.setAttribute("result", rs);

                    request.setAttribute("process", process);
                    RequestDispatcher view = request.getRequestDispatcher("purchase.jsp");
                    view.forward(request, response);
                }

            } catch (Exception ex) {
                out.print(ex.getMessage());
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
