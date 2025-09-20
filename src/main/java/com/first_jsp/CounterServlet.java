package com.first_jsp;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet(name="CounterServlet", urlPatterns ={"/counter", "/counter/*"})
public class CounterServlet extends HttpServlet {
    private final AtomicInteger counter = new AtomicInteger();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        int n = counter.incrementAndGet();
        try
        {
            Thread.sleep(3000);
        }
        catch(InterruptedException ignored)
        {

        }
        response.getWriter().println("Thread: " + Thread.currentThread().getName()+" | counter= " +n);
    }
}
