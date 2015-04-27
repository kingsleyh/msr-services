package com.msr.conf

trait Model {
  private val items = Item(1, 2, "foo", "More information about Foo") ::
    Item(2, 3, "bar", "More information about Bar") ::
    Item(3, 5, "qux", "More information about Qux") ::
    Item(4, 7, "quux", "More information about Quux") ::
    Item(5, 7, "quuux", "More information about Quuux") ::
    Nil

  val summary = (i: Item) => ItemSummary(i.id, i.stock, i.title)

  def get(id: Int) = items find (_.id == id)

  def list = items map { summary }

  def query(s: String) = items filter (_.desc.contains(s)) map summary

}
