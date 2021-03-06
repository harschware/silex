/*
 * This file is part of the "silex" library of helpers for Apache Spark.
 *
 * Copyright (c) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.redhat.et.silex.util

import org.scalatest._

class RegexImplicitsSpec extends FlatSpec with Matchers {
  import OptionalArgProperties._

  it should "use the r-interpolator to generate a regex" in {
    import RegexImplicits._
    
    val matches = "123::456" match {
      case r"([0-9]+)$first::([0-9]+)$second" => (first, second)
      case _ => ("", "")
    }
    
    assert(matches == ("123", "456"))
  }
}
