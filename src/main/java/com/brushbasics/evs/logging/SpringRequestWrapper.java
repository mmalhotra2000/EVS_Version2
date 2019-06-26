package com.brushbasics.evs.logging;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.io.IOUtils;

public class SpringRequestWrapper extends HttpServletRequestWrapper {

    private byte[] body;

    public SpringRequestWrapper(HttpServletRequest request) {
        super(request);
        try {
            body = IOUtils.toByteArray(request.getInputStream());
        } catch (IOException ex) {
            body = new byte[0];
        }
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        return new ServletInputStream() {
            public boolean isFinished() {
                return false;
            }

            public boolean isReady() {
                return true;
            }

            public void setReadListener(ReadListener readListener) {

            }

            ByteArrayInputStream byteArray = new ByteArrayInputStream(body);

            @Override
            public int read() throws IOException {
                return byteArray.read();
            }
        };
    }

    public Map<String, String> getAllHeaders() {
		final Map<String, String> headers = new HashMap<>();
		// getHeaderNames().forEachRemaining(it -> headers.put(it, getHeader(it)));
		Enumeration<String> enumm = getHeaderNames();

		while (enumm.hasMoreElements()) {
			String test = enumm.nextElement();
			headers.put(test, getHeader(test));
		}
		return headers;
	}
}