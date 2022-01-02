/**
 * Copyright 2021 The kage Authors. All rights reserved.
 * Use of this source code is governed by either an
 * Apache 2.0 or MIT license at your discretion, that can
 * be found in the LICENSE-APACHE or LICENSE-MIT files
 * respectively.
 */
package kage.format

public sealed class ParseException
@JvmOverloads
constructor(
  message: String? = null,
  cause: Throwable? = null,
) : Exception(message, cause)

public class InvalidArbitraryStringException
@JvmOverloads
constructor(
  message: String? = null,
  cause: Throwable? = null,
) : ParseException(message, cause)

public class InvalidVersionException
@JvmOverloads
constructor(
  message: String? = null,
  cause: Throwable? = null,
) : ParseException(message, cause)

public class InvalidRecipientException
@JvmOverloads
constructor(
  message: String? = null,
  cause: Throwable? = null,
) : ParseException(message, cause)

public class InvalidFooterException
@JvmOverloads
constructor(
  message: String? = null,
  cause: Throwable? = null,
) : ParseException(message, cause)
