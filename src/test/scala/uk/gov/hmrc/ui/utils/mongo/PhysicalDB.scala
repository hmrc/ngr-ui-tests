/*
 * Copyright 2025 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.ui.utils.mongo

import com.mongodb.client.model.IndexOptions
import org.mongodb.scala.model.Filters.expr
import org.mongodb.scala.{Document, MongoClient, MongoCollection, MongoDatabase}
import uk.gov.hmrc.ui.utils.mongo.MongoHelper.GenericObservable

object PhysicalDB {
  private val env                         = System.getProperty("environment")
  val mongoClient: MongoClient            = MongoClient()
  def database(db: String): MongoDatabase = mongoClient.getDatabase(db)

  def collection(db: String, collection: String): MongoCollection[Document] = database(db).getCollection(collection)

  def indexOptions(name: String, unique: Boolean): IndexOptions = new IndexOptions().name(name).unique(unique)

  def cleanup(): Unit =
    if (env == "local") {
      collection("ngr-physical-frontend", "user-answers").deleteMany(expr("1 == 1")).results()
    }
}
