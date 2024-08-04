package com.santos.helpdesk.exceptions;

import java.util.Date;

public record ResponseGlobalException(Date timestamp, String message, String details) {
}
