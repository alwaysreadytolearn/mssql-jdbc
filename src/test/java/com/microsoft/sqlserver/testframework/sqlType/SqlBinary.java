// ---------------------------------------------------------------------------------------------------------------------------------
// File: SqlBinary.java
//
//
// Microsoft JDBC Driver for SQL Server
// Copyright(c) Microsoft Corporation
// All rights reserved.
// MIT License
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files(the "Software"),
// to deal in the Software without restriction, including without limitation the
// rights to use, copy, modify, merge, publish, distribute, sublicense,
// and / or sell copies of the Software, and to permit persons to whom the
// Software is furnished to do so, subject to the following conditions :
// The above copyright notice and this permission notice shall be included in
// all copies or substantial portions of the Software.
// THE SOFTWARE IS PROVIDED *AS IS*, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
// IN THE SOFTWARE.
// ---------------------------------------------------------------------------------------------------------------------------------

package com.microsoft.sqlserver.testframework.sqlType;

import java.sql.JDBCType;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Contains name, jdbctype, precision, scale for binary data type
 */
public class SqlBinary extends SqlType {

    /**
     * set JDBCType and precision for SqlBinary
     */
    public SqlBinary() {
        this("binary", JDBCType.BINARY, 2000);
    }

    /**
     * 
     * @param name binary or varbinary
     * @param jdbctype
     * @param precision
     */
    SqlBinary(String name, JDBCType jdbctype, int precision) {
        super(name, jdbctype, precision, 0, SqlTypeValue.BINARY.minValue, SqlTypeValue.BINARY.maxValue, SqlTypeValue.BINARY.nullValue,
                VariableLengthType.Precision);
        generatePrecision();
    }

    /**
     * create random data for binary and varbinary column
     */
    public Object createdata() {
        int dataLength = ThreadLocalRandom.current().nextInt(precision);
        byte[] bytes = new byte[dataLength];
        ThreadLocalRandom.current().nextBytes(bytes);
        return bytes;
    }
}