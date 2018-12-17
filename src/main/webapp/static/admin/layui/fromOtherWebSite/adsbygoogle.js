(function() {
	var l, ba = "function" == typeof Object.create ? Object.create : function(a) {
			function b() {}
			b.prototype = a;
			return new b
		},
		ca;
	if("function" == typeof Object.setPrototypeOf) ca = Object.setPrototypeOf;
	else {
		var da;
		a: {
			var ea = {
					ma: !0
				},
				fa = {};
			try {
				fa.__proto__ = ea;
				da = fa.ma;
				break a
			} catch(a) {}
			da = !1
		}
		ca = da ? function(a, b) {
			a.__proto__ = b;
			if(a.__proto__ !== b) throw new TypeError(a + " is not extensible");
			return a
		} : null
	}
	var ha = ca;

	function ia(a, b) {
		a.prototype = ba(b.prototype);
		a.prototype.constructor = a;
		if(ha) ha(a, b);
		else
			for(var c in b)
				if("prototype" != c)
					if(Object.defineProperties) {
						var d = Object.getOwnPropertyDescriptor(b, c);
						d && Object.defineProperty(a, c, d)
					} else a[c] = b[c];
		a.Ca = b.prototype
	}
	var ja = "function" == typeof Object.defineProperties ? Object.defineProperty : function(a, b, c) {
			a != Array.prototype && a != Object.prototype && (a[b] = c.value)
		},
		ka = "undefined" != typeof window && window === this ? this : "undefined" != typeof global && null != global ? global : this;

	function la(a, b) {
		if(b) {
			var c = ka;
			a = a.split(".");
			for(var d = 0; d < a.length - 1; d++) {
				var e = a[d];
				e in c || (c[e] = {});
				c = c[e]
			}
			a = a[a.length - 1];
			d = c[a];
			b = b(d);
			b != d && null != b && ja(c, a, {
				configurable: !0,
				writable: !0,
				value: b
			})
		}
	}
	la("String.prototype.endsWith", function(a) {
		return a ? a : function(a, c) {
			if(null == this) throw new TypeError("The 'this' value for String.prototype.endsWith must not be null or undefined");
			if(a instanceof RegExp) throw new TypeError("First argument to String.prototype.endsWith must not be a regular expression");
			void 0 === c && (c = this.length);
			c = Math.max(0, Math.min(c | 0, this.length));
			for(var b = a.length; 0 < b && 0 < c;)
				if(this[--c] != a[--b]) return !1;
			return 0 >= b
		}
	});
	var ma = "function" == typeof Object.assign ? Object.assign : function(a, b) {
		for(var c = 1; c < arguments.length; c++) {
			var d = arguments[c];
			if(d)
				for(var e in d) Object.prototype.hasOwnProperty.call(d, e) && (a[e] = d[e])
		}
		return a
	};
	la("Object.assign", function(a) {
		return a || ma
	});
	la("Object.is", function(a) {
		return a ? a : function(a, c) {
			return a === c ? 0 !== a || 1 / a === 1 / c : a !== a && c !== c
		}
	});
	la("Number.isNaN", function(a) {
		return a ? a : function(a) {
			return "number" === typeof a && isNaN(a)
		}
	});
	var r = this;

	function t(a) {
		return "string" == typeof a
	}

	function na(a) {
		return "boolean" == typeof a
	}

	function v(a) {
		return "number" == typeof a
	}

	function oa() {
		if(null === pa) a: {
			var a = r.document;
			if((a = a.querySelector && a.querySelector("script[nonce]")) && (a = a.nonce || a.getAttribute("nonce")) && qa.test(a)) {
				pa = a;
				break a
			}
			pa = ""
		}
		return pa
	}
	var qa = /^[\w+/_-]+[=]{0,2}$/,
		pa = null;

	function ra() {}

	function ta(a) {
		var b = typeof a;
		if("object" == b)
			if(a) {
				if(a instanceof Array) return "array";
				if(a instanceof Object) return b;
				var c = Object.prototype.toString.call(a);
				if("[object Window]" == c) return "object";
				if("[object Array]" == c || "number" == typeof a.length && "undefined" != typeof a.splice && "undefined" != typeof a.propertyIsEnumerable && !a.propertyIsEnumerable("splice")) return "array";
				if("[object Function]" == c || "undefined" != typeof a.call && "undefined" != typeof a.propertyIsEnumerable && !a.propertyIsEnumerable("call")) return "function"
			} else return "null";
		else if("function" == b && "undefined" == typeof a.call) return "object";
		return b
	}

	function ua(a) {
		return null === a
	}

	function va(a) {
		var b = typeof a;
		return "object" == b && null != a || "function" == b
	}

	function wa(a, b, c) {
		return a.call.apply(a.bind, arguments)
	}

	function xa(a, b, c) {
		if(!a) throw Error();
		if(2 < arguments.length) {
			var d = Array.prototype.slice.call(arguments, 2);
			return function() {
				var c = Array.prototype.slice.call(arguments);
				Array.prototype.unshift.apply(c, d);
				return a.apply(b, c)
			}
		}
		return function() {
			return a.apply(b, arguments)
		}
	}

	function ya(a, b, c) {
		Function.prototype.bind && -1 != Function.prototype.bind.toString().indexOf("native code") ? ya = wa : ya = xa;
		return ya.apply(null, arguments)
	}

	function za(a, b) {
		var c = Array.prototype.slice.call(arguments, 1);
		return function() {
			var b = c.slice();
			b.push.apply(b, arguments);
			return a.apply(this, b)
		}
	}

	function w(a, b) {
		function c() {}
		c.prototype = b.prototype;
		a.Ca = b.prototype;
		a.prototype = new c;
		a.prototype.constructor = a;
		a.Ma = function(a, c, f) {
			for(var d = Array(arguments.length - 2), e = 2; e < arguments.length; e++) d[e - 2] = arguments[e];
			return b.prototype[c].apply(a, d)
		}
	};
	var Aa = (new Date).getTime();

	function Ba(a, b) {
		if(t(a)) return t(b) && 1 == b.length ? a.indexOf(b, 0) : -1;
		for(var c = 0; c < a.length; c++)
			if(c in a && a[c] === b) return c;
		return -1
	}

	function Ca(a, b) {
		for(var c = a.length, d = t(a) ? a.split("") : a, e = 0; e < c; e++) e in d && b.call(void 0, d[e], e, a)
	}

	function Da(a, b) {
		for(var c = a.length, d = Array(c), e = t(a) ? a.split("") : a, f = 0; f < c; f++) f in e && (d[f] = b.call(void 0, e[f], f, a));
		return d
	}

	function Ea(a, b) {
		a: {
			for(var c = a.length, d = t(a) ? a.split("") : a, e = 0; e < c; e++)
				if(e in d && b.call(void 0, d[e], e, a)) {
					b = e;
					break a
				}
			b = -1
		}
		return 0 > b ? null : t(a) ? a.charAt(b) : a[b]
	}

	function Fa(a) {
		return Array.prototype.concat.apply([], arguments)
	};

	function Ga(a) {
		return /^[\s\xa0]*([\s\S]*?)[\s\xa0]*$/.exec(a)[1]
	}

	function Ha(a) {
		if(!Ia.test(a)) return a; - 1 != a.indexOf("&") && (a = a.replace(Ja, "&amp;")); - 1 != a.indexOf("<") && (a = a.replace(Ka, "&lt;")); - 1 != a.indexOf(">") && (a = a.replace(La, "&gt;")); - 1 != a.indexOf('"') && (a = a.replace(Ma, "&quot;")); - 1 != a.indexOf("'") && (a = a.replace(Na, "&#39;")); - 1 != a.indexOf("\x00") && (a = a.replace(Oa, "&#0;"));
		return a
	}
	var Ja = /&/g,
		Ka = /</g,
		La = />/g,
		Ma = /"/g,
		Na = /'/g,
		Oa = /\x00/g,
		Ia = /[\x00&<>"']/,
		Pa = {
			"\x00": "\\0",
			"\b": "\\b",
			"\f": "\\f",
			"\n": "\\n",
			"\r": "\\r",
			"\t": "\\t",
			"\x0B": "\\x0B",
			'"': '\\"',
			"\\": "\\\\",
			"<": "<"
		},
		Ra = {
			"'": "\\'"
		};

	function x(a, b) {
		return -1 != a.indexOf(b)
	}

	function Sa(a) {
		return String(a).replace(/\-([a-z])/g, function(a, c) {
			return c.toUpperCase()
		})
	};
	var y;
	a: {
		var Ta = r.navigator;
		if(Ta) {
			var Ua = Ta.userAgent;
			if(Ua) {
				y = Ua;
				break a
			}
		}
		y = ""
	};

	function Va(a, b) {
		for(var c in a)
			if(b.call(void 0, a[c], c, a)) return !0;
		return !1
	}

	function Wa(a) {
		var b = [],
			c = 0,
			d;
		for(d in a) b[c++] = a[d];
		return b
	};

	function Xa(a) {
		Xa[" "](a);
		return a
	}
	Xa[" "] = ra;

	function z() {}
	var Ya = "function" == typeof Uint8Array;

	function A(a, b, c) {
		a.a = null;
		b || (b = []);
		a.A = void 0;
		a.h = -1;
		a.b = b;
		a: {
			if(b = a.b.length) {
				--b;
				var d = a.b[b];
				if(null !== d && "object" == typeof d && "array" != ta(d) && !(Ya && d instanceof Uint8Array)) {
					a.i = b - a.h;
					a.g = d;
					break a
				}
			}
			a.i = Number.MAX_VALUE
		}
		a.w = {};
		if(c)
			for(b = 0; b < c.length; b++) d = c[b], d < a.i ? (d += a.h, a.b[d] = a.b[d] || Za) : ($a(a), a.g[d] = a.g[d] || Za)
	}
	var Za = [];

	function $a(a) {
		var b = a.i + a.h;
		a.b[b] || (a.g = a.b[b] = {})
	}

	function B(a, b) {
		if(b < a.i) {
			b += a.h;
			var c = a.b[b];
			return c === Za ? a.b[b] = [] : c
		}
		if(a.g) return c = a.g[b], c === Za ? a.g[b] = [] : c
	}

	function ab(a, b) {
		if(b < a.i) {
			b += a.h;
			var c = a.b[b];
			return c === Za ? a.b[b] = [] : c
		}
		c = a.g[b];
		return c === Za ? a.g[b] = [] : c
	}

	function bb(a, b, c) {
		a.a || (a.a = {});
		if(!a.a[c]) {
			var d = B(a, c);
			d && (a.a[c] = new b(d))
		}
		return a.a[c]
	}

	function cb(a, b, c) {
		a.a || (a.a = {});
		if(!a.a[c]) {
			for(var d = ab(a, c), e = [], f = 0; f < d.length; f++) e[f] = new b(d[f]);
			a.a[c] = e
		}
		b = a.a[c];
		b == Za && (b = a.a[c] = []);
		return b
	}

	function db(a) {
		if(a.a)
			for(var b in a.a) {
				var c = a.a[b];
				if("array" == ta(c))
					for(var d = 0; d < c.length; d++) c[d] && db(c[d]);
				else c && db(c)
			}
		return a.b
	};

	function eb(a) {
		A(this, a, fb)
	}
	w(eb, z);

	function gb(a) {
		A(this, a, null)
	}
	w(gb, z);
	var fb = [2, 3];
	var hb = document,
		C = window;
	var ib = {
		"120x90": !0,
		"160x90": !0,
		"180x90": !0,
		"200x90": !0,
		"468x15": !0,
		"728x15": !0
	};

	function jb(a, b) {
		if(15 == b) {
			if(728 <= a) return 728;
			if(468 <= a) return 468
		} else if(90 == b) {
			if(200 <= a) return 200;
			if(180 <= a) return 180;
			if(160 <= a) return 160;
			if(120 <= a) return 120
		}
		return null
	};

	function kb() {
		return function() {
			return !ua.apply(this, arguments)
		}
	}

	function lb(a) {
		var b = !1,
			c;
		return function() {
			b || (c = a(), b = !0);
			return c
		}
	}

	function mb() {
		var a = ra;
		return function() {
			if(a) {
				var b = a;
				a = null;
				b()
			}
		}
	};

	function nb() {
		this.b = "";
		this.h = ob
	}
	nb.prototype.g = !0;
	nb.prototype.a = function() {
		return this.b
	};

	function pb(a) {
		if(a instanceof nb && a.constructor === nb && a.h === ob) return a.b;
		ta(a);
		return "type_error:TrustedResourceUrl"
	}
	var ob = {};

	function qb() {
		this.J = "";
		this.la = rb
	}
	qb.prototype.g = !0;
	qb.prototype.a = function() {
		return this.J
	};
	var sb = /^(?:(?:https?|mailto|ftp):|[^:/?#]*(?:[/?#]|$))/i,
		rb = {};

	function tb(a) {
		var b = new qb;
		b.J = a;
		return b
	}
	tb("about:blank");

	function ub(a, b) {
		a.src = pb(b);
		(b = oa()) && a.setAttribute("nonce", b)
	};

	function vb(a) {
		this.a = a || r.document || document
	}

	function wb(a, b) {
		return a.a.createElement(String(b))
	}
	vb.prototype.contains = function(a, b) {
		if(!a || !b) return !1;
		if(a.contains && 1 == b.nodeType) return a == b || a.contains(b);
		if("undefined" != typeof a.compareDocumentPosition) return a == b || !!(a.compareDocumentPosition(b) & 16);
		for(; b && a != b;) b = b.parentNode;
		return b == a
	};

	function xb(a) {
		yb();
		var b = new nb;
		b.b = a;
		return b
	}
	var yb = ra;

	function zb() {
		return !(x(y, "iPad") || x(y, "Android") && !x(y, "Mobile") || x(y, "Silk")) && (x(y, "iPod") || x(y, "iPhone") || x(y, "Android") || x(y, "IEMobile"))
	};

	function D(a) {
		try {
			var b;
			if(b = !!a && null != a.location.href) a: {
				try {
					Xa(a.foo);
					b = !0;
					break a
				} catch(c) {}
				b = !1
			}
			return b
		} catch(c) {
			return !1
		}
	}

	function Ab(a) {
		for(var b = r, c = 0; b && 40 > c++ && (!D(b) || !a(b));) b = Bb(b)
	}

	function Cb() {
		var a = r;
		Ab(function(b) {
			a = b;
			return !1
		});
		return a
	}

	function Bb(a) {
		try {
			var b = a.parent;
			if(b && b != a) return b
		} catch(c) {}
		return null
	}

	function Db(a, b) {
		var c = [r.top],
			d = [],
			e = 0;
		b = b || 1024;
		for(var f; f = c[e++];) {
			a && !D(f) || d.push(f);
			try {
				if(f.frames)
					for(var g = f.frames.length, h = 0; h < g && c.length < b; ++h) c.push(f.frames[h])
			} catch(k) {}
		}
		return d
	}

	function Eb(a, b) {
		var c = a.createElement("script");
		ub(c, xb(b));
		return(a = a.getElementsByTagName("script")[0]) && a.parentNode ? (a.parentNode.insertBefore(c, a), c) : null
	}

	function E(a, b) {
		return b.getComputedStyle ? b.getComputedStyle(a, null) : a.currentStyle
	}

	function Fb(a) {
		if(!a.crypto) return Math.random();
		try {
			var b = new Uint32Array(1);
			a.crypto.getRandomValues(b);
			return b[0] / 65536 / 65536
		} catch(c) {
			return Math.random()
		}
	}

	function Gb(a, b) {
		if(a)
			for(var c in a) Object.prototype.hasOwnProperty.call(a, c) && b.call(void 0, a[c], c, a)
	}

	function Hb(a) {
		var b = a.length;
		if(0 == b) return 0;
		for(var c = 305419896, d = 0; d < b; d++) c ^= (c << 5) + (c >> 2) + a.charCodeAt(d) & 4294967295;
		return 0 < c ? c : 4294967296 + c
	}
	var Ib = lb(function() {
			return x(y, "Google Web Preview") || 1E-4 > Math.random()
		}),
		Jb = /^([0-9.]+)px$/,
		Kb = /^(-?[0-9.]{1,30})$/;

	function Lb(a) {
		return Kb.test(a) && (a = Number(a), !isNaN(a)) ? a : null
	}

	function Mb(a, b) {
		return b ? !/^false$/.test(a) : /^true$/.test(a)
	}

	function F(a) {
		return(a = Jb.exec(a)) ? +a[1] : null
	}

	function Nb(a, b) {
		try {
			return !(!a.frames || !a.frames[b])
		} catch(c) {
			return !1
		}
	}

	function Ob(a) {
		var b = {
			display: "none"
		};
		a.style.setProperty ? Gb(b, function(b, d) {
			a.style.setProperty(d, b, "important")
		}) : a.style.cssText = Pb(Qb(Rb(a.style.cssText), Sb(b, function(a) {
			return a + " !important"
		})))
	}
	var Qb = Object.assign || function(a, b) {
		for(var c = 1; c < arguments.length; c++) {
			var d = arguments[c];
			if(d)
				for(var e in d) Object.prototype.hasOwnProperty.call(d, e) && (a[e] = d[e])
		}
		return a
	};

	function Sb(a, b) {
		var c = {},
			d;
		for(d in a) Object.prototype.hasOwnProperty.call(a, d) && (c[d] = b.call(void 0, a[d], d, a));
		return c
	}

	function Pb(a) {
		var b = [];
		Gb(a, function(a, d) {
			null != a && "" !== a && b.push(d + ":" + a)
		});
		return b.length ? b.join(";") + ";" : ""
	}

	function Rb(a) {
		var b = {};
		if(a) {
			var c = /\s*:\s*/;
			a = (a || "").split(/\s*;\s*/);
			Ca(a, function(a) {
				if(a) {
					var d = a.split(c);
					a = d[0];
					d = d[1];
					a && d && (b[a.toLowerCase()] = d)
				}
			})
		}
		return b
	};

	function Tb(a, b, c) {
		a.addEventListener && a.addEventListener(b, c, !1)
	};

	function Ub(a, b) {
		var c = !1,
			d = !1;
		d = void 0 === d ? !1 : d;
		c = void 0 === c ? !1 : c;
		r.google_image_requests || (r.google_image_requests = []);
		var e = r.document.createElement("img");
		if(b || c) {
			var f = function(a) {
				b && b(a);
				if(c) {
					a = r.google_image_requests;
					var d = Ba(a, e);
					0 <= d && Array.prototype.splice.call(a, d, 1)
				}
				e.removeEventListener && e.removeEventListener("load", f, !1);
				e.removeEventListener && e.removeEventListener("error", f, !1)
			};
			Tb(e, "load", f);
			Tb(e, "error", f)
		}
		d && (e.referrerPolicy = "no-referrer");
		e.src = a;
		r.google_image_requests.push(e)
	};

	function Vb(a, b) {
		a = parseInt(a, 10);
		return isNaN(a) ? b : a
	}
	var Wb = /^([\w-]+\.)*([\w-]{2,})(:[0-9]+)?$/;

	function Xb(a, b) {
		return a ? (a = a.match(Wb)) ? a[0] : b : b
	};
	var Yb = Vb("468", 0);

	function Zb() {
		return "r20181107"
	}
	var $b = Mb("false", !1),
		ac = Mb("true", !1),
		bc = Mb("true", !1),
		cc = bc || !ac;

	function dc() {
		return Xb("", "googleads.g.doubleclick.net")
	}

	function ec(a) {
		return a ? "pagead2.googlesyndication.com" : Xb("", "pagead2.googlesyndication.com")
	};

	function fc(a) {
		a = void 0 === a ? r : a;
		var b = a.context || a.AMP_CONTEXT_DATA;
		if(!b) try {
			b = a.parent.context || a.parent.AMP_CONTEXT_DATA
		} catch(c) {}
		try {
			if(b && b.pageViewId && b.canonicalUrl) return b
		} catch(c) {}
		return null
	}

	function gc(a) {
		return(a = a || fc()) ? D(a.master) ? a.master : null : null
	};

	function hc(a, b) {
		for(var c in a) Object.prototype.hasOwnProperty.call(a, c) && b.call(void 0, a[c], c, a)
	}

	function ic(a) {
		return !(!a || !a.call) && "function" === typeof a
	}

	function jc(a, b) {
		if(a.indexOf) return a = a.indexOf(b), 0 < a || 0 === a;
		for(var c = 0; c < a.length; c++)
			if(a[c] === b) return !0;
		return !1
	}

	function kc(a) {
		a = gc(fc(a)) || a;
		a.google_unique_id ? ++a.google_unique_id : a.google_unique_id = 1
	}
	var lc = !!window.google_async_iframe_id,
		mc = lc && window.parent || window;

	function nc() {
		if(lc && !D(mc)) {
			var a = "." + hb.domain;
			try {
				for(; 2 < a.split(".").length && !D(mc);) hb.domain = a = a.substr(a.indexOf(".") + 1), mc = window.parent
			} catch(b) {}
			D(mc) || (mc = window)
		}
		return mc
	}
	var oc = /(^| )adsbygoogle($| )/;

	function pc(a) {
		return $b && a.google_top_window || a.top
	}

	function G(a) {
		a = pc(a);
		return D(a) ? a : null
	};

	function I(a, b) {
		a = a.google_ad_modifications;
		return jc(a ? a.eids || [] : [], b)
	}

	function qc(a) {
		return(a = a.google_ad_modifications) ? a.loeids || [] : []
	}

	function rc(a, b) {
		a = a.google_ad_modifications = a.google_ad_modifications || {};
		(a.tag_partners = a.tag_partners || []).push(b)
	}

	function sc(a, b, c) {
		if(!a) return null;
		for(var d = 0; d < a.length; ++d)
			if((a[d].ad_slot || b) == b && (a[d].ad_tag_origin || c) == c) return a[d];
		return null
	};
	var tc = {
			overlays: 1,
			interstitials: 2,
			vignettes: 2,
			inserts: 3,
			immersives: 4,
			list_view: 5,
			full_page: 6
		},
		uc = {
			Ga: {
				name: "adFormat",
				o: v
			},
			Fa: {
				name: "adClient",
				o: /^[a-z0-9-]+$/i
			},
			Ia: {
				name: "adTest",
				o: /^on$/i
			},
			La: {
				name: "reqSrc",
				o: v
			},
			Ka: {
				name: "pubVars",
				o: null
			},
			Ha: {
				name: "adKey",
				o: v
			},
			Ja: {
				name: "enabledInAsfe",
				o: na
			}
		};
	var vc = [{
		name: "google_ad_channel",
		o: {
			predicate: /^[a-z0-9_-]+$/i,
			nullOnInvalid: !0
		}
	}, {
		name: "google_reactive_sra_index",
		o: {
			predicate: v,
			nullOnInvalid: !0
		}
	}, {
		name: "google_ad_unit_key",
		o: {
			predicate: v,
			nullOnInvalid: !0
		}
	}];

	function wc(a) {
		A(this, a, yc)
	}
	w(wc, z);

	function zc(a) {
		A(this, a, null)
	}
	w(zc, z);

	function Ac(a) {
		A(this, a, null)
	}
	w(Ac, z);

	function Bc(a) {
		A(this, a, Cc)
	}
	w(Bc, z);
	var yc = [4],
		Cc = [6, 7, 9, 10, 11];

	function Dc(a) {
		A(this, a, Ec)
	}
	w(Dc, z);

	function Fc(a) {
		A(this, a, null)
	}
	w(Fc, z);

	function Gc(a) {
		A(this, a, Hc)
	}
	w(Gc, z);

	function Ic(a) {
		A(this, a, null)
	}
	w(Ic, z);
	var Ec = [1, 2, 5, 7],
		Hc = [2];

	function Jc(a, b, c) {
		c = void 0 === c ? {} : c;
		this.error = a;
		this.context = b.context;
		this.line = b.line || -1;
		this.msg = b.message || "";
		this.file = b.file || "";
		this.id = b.id || "jserror";
		this.meta = c
	};
	var Kc = /^https?:\/\/(\w|-)+\.cdn\.ampproject\.(net|org)(\?|\/|$)/;

	function Lc(a, b) {
		this.a = a;
		this.b = b
	}

	function Mc(a, b, c) {
		this.url = a;
		this.a = b;
		this.X = !!c;
		this.depth = v(void 0) ? void 0 : null
	};

	function Nc() {
		this.g = "&";
		this.h = !1;
		this.b = {};
		this.i = 0;
		this.a = []
	}

	function Oc(a, b) {
		var c = {};
		c[a] = b;
		return [c]
	}

	function Pc(a, b, c, d, e) {
		var f = [];
		Gb(a, function(a, h) {
			(a = Qc(a, b, c, d, e)) && f.push(h + "=" + a)
		});
		return f.join(b)
	}

	function Qc(a, b, c, d, e) {
		if(null == a) return "";
		b = b || "&";
		c = c || ",$";
		"string" == typeof c && (c = c.split(""));
		if(a instanceof Array) {
			if(d = d || 0, d < c.length) {
				for(var f = [], g = 0; g < a.length; g++) f.push(Qc(a[g], b, c, d + 1, e));
				return f.join(c[d])
			}
		} else if("object" == typeof a) return e = e || 0, 2 > e ? encodeURIComponent(Pc(a, b, c, d, e + 1)) : "...";
		return encodeURIComponent(String(a))
	}

	function Rc(a, b, c, d) {
		a.a.push(b);
		a.b[b] = Oc(c, d)
	}

	function Sc(a, b, c, d) {
		b = b + "//" + c + d;
		var e = Tc(a) - d.length;
		if(0 > e) return "";
		a.a.sort(function(a, b) {
			return a - b
		});
		d = null;
		c = "";
		for(var f = 0; f < a.a.length; f++)
			for(var g = a.a[f], h = a.b[g], k = 0; k < h.length; k++) {
				if(!e) {
					d = null == d ? g : d;
					break
				}
				var m = Pc(h[k], a.g, ",$");
				if(m) {
					m = c + m;
					if(e >= m.length) {
						e -= m.length;
						b += m;
						c = a.g;
						break
					} else a.h && (c = e, m[c - 1] == a.g && --c, b += m.substr(0, c), c = a.g, e = 0);
					d = null == d ? g : d
				}
			}
		a = "";
		null != d && (a = c + "trn=" + d);
		return b + a
	}

	function Tc(a) {
		var b = 1,
			c;
		for(c in a.b) b = c.length > b ? c.length : b;
		return 3997 - b - a.g.length - 1
	};

	function Uc(a, b, c, d, e, f) {
		if((d ? a.i : Math.random()) < (e || a.a)) try {
			if(c instanceof Nc) var g = c;
			else g = new Nc, Gb(c, function(a, b) {
				var c = g,
					d = c.i++;
				a = Oc(b, a);
				c.a.push(d);
				c.b[d] = a
			});
			var h = Sc(g, a.h, a.b, a.g + b + "&");
			h && ("undefined" === typeof f ? Ub(h, void 0) : Ub(h, f))
		} catch(k) {}
	};

	function Vc(a, b) {
		this.start = a < b ? a : b;
		this.a = a < b ? b : a
	};

	function Wc(a, b) {
		this.a = b >= a ? new Vc(a, b) : null
	}

	function Xc(a) {
		var b = -1;
		try {
			a.localStorage && (b = parseInt(a.localStorage.getItem("google_experiment_mod"), 10))
		} catch(c) {
			return null
		}
		if(0 <= b && 1E3 > b) return b;
		if(Ib()) return null;
		b = Math.floor(1E3 * Fb(a));
		try {
			if(a.localStorage) return a.localStorage.setItem("google_experiment_mod", "" + b), b
		} catch(c) {}
		return null
	};
	var Yc = null;

	function Zc() {
		var a = r.performance;
		return a && a.now && a.timing ? Math.floor(a.now() + a.timing.navigationStart) : +new Date
	}

	function $c() {
		var a = void 0 === a ? r : a;
		return(a = a.performance) && a.now ? a.now() : null
	};

	function ad(a, b, c) {
		this.label = a;
		this.type = b;
		this.value = c;
		this.duration = 0;
		this.uniqueId = this.label + "_" + this.type + "_" + Math.random();
		this.slotId = void 0
	};
	var J = r.performance,
		bd = !!(J && J.mark && J.measure && J.clearMarks),
		cd = lb(function() {
			var a;
			if(a = bd) {
				var b;
				if(null === Yc) {
					Yc = "";
					try {
						a = "";
						try {
							a = r.top.location.hash
						} catch(c) {
							a = r.location.hash
						}
						a && (Yc = (b = a.match(/\bdeid=([\d,]+)/)) ? b[1] : "")
					} catch(c) {}
				}
				b = Yc;
				a = !!b.indexOf && 0 <= b.indexOf("1337")
			}
			return a
		});

	function dd() {
		var a = ed;
		this.b = [];
		this.g = a || r;
		var b = null;
		a && (a.google_js_reporting_queue = a.google_js_reporting_queue || [], this.b = a.google_js_reporting_queue, b = a.google_measure_js_timing);
		this.a = cd() || (null != b ? b : 1 > Math.random())
	}

	function fd(a) {
		a && J && cd() && (J.clearMarks("goog_" + a.uniqueId + "_start"), J.clearMarks("goog_" + a.uniqueId + "_end"))
	}
	dd.prototype.start = function(a, b) {
		if(!this.a) return null;
		var c = $c() || Zc();
		a = new ad(a, b, c);
		b = "goog_" + a.uniqueId + "_start";
		J && cd() && J.mark(b);
		return a
	};

	function gd() {
		var a = hd;
		this.w = id;
		this.h = !0;
		this.g = null;
		this.A = this.a;
		this.b = void 0 === a ? null : a;
		this.i = !1
	}

	function jd(a, b, c, d, e) {
		try {
			if(a.b && a.b.a) {
				var f = a.b.start(b.toString(), 3);
				var g = c();
				var h = a.b;
				c = f;
				if(h.a && v(c.value)) {
					var k = $c() || Zc();
					c.duration = k - c.value;
					var m = "goog_" + c.uniqueId + "_end";
					J && cd() && J.mark(m);
					h.a && h.b.push(c)
				}
			} else g = c()
		} catch(n) {
			h = a.h;
			try {
				fd(f), h = (e || a.A).call(a, b, new kd(ld(n), n.fileName, n.lineNumber), void 0, d)
			} catch(p) {
				a.a(217, p)
			}
			if(!h) throw n;
		}
		return g
	}

	function md(a, b) {
		var c = K;
		return function(d) {
			for(var e = [], f = 0; f < arguments.length; ++f) e[f] = arguments[f];
			return jd(c, a, function() {
				return b.apply(void 0, e)
			}, void 0, void 0)
		}
	}
	gd.prototype.a = function(a, b, c, d, e) {
		e = e || "jserror";
		try {
			var f = new Nc;
			f.h = !0;
			Rc(f, 1, "context", a);
			b.error && b.meta && b.id || (b = new kd(ld(b), b.fileName, b.lineNumber));
			b.msg && Rc(f, 2, "msg", b.msg.substring(0, 512));
			b.file && Rc(f, 3, "file", b.file);
			0 < b.line && Rc(f, 4, "line", b.line);
			var g = b.meta || {};
			if(this.g) try {
				this.g(g)
			} catch(sa) {}
			if(d) try {
				d(g)
			} catch(sa) {}
			b = [g];
			f.a.push(5);
			f.b[5] = b;
			d = r;
			b = [];
			g = null;
			do {
				var h = d;
				if(D(h)) {
					var k = h.location.href;
					g = h.document && h.document.referrer || null
				} else k = g, g = null;
				b.push(new Mc(k || "", h));
				try {
					d = h.parent
				} catch(sa) {
					d = null
				}
			} while (d && h != d);
			k = 0;
			for(var m = b.length - 1; k <= m; ++k) b[k].depth = m - k;
			h = r;
			if(h.location && h.location.ancestorOrigins && h.location.ancestorOrigins.length == b.length - 1)
				for(m = 1; m < b.length; ++m) {
					var n = b[m];
					n.url || (n.url = h.location.ancestorOrigins[m - 1] || "", n.X = !0)
				}
			var p = new Mc(r.location.href, r, !1);
			h = null;
			var u = b.length - 1;
			for(n = u; 0 <= n; --n) {
				var q = b[n];
				!h && Kc.test(q.url) && (h = q);
				if(q.url && !q.X) {
					p = q;
					break
				}
			}
			q = null;
			var H = b.length && b[u].url;
			0 != p.depth && H && (q = b[u]);
			var aa = new Lc(p, q);
			aa.b && Rc(f, 6, "top", aa.b.url || "");
			Rc(f, 7, "url", aa.a.url || "");
			Uc(this.w, e, f, this.i, c)
		} catch(sa) {
			try {
				Uc(this.w, e, {
					context: "ecmserr",
					rctx: a,
					msg: ld(sa),
					url: aa && aa.a.url
				}, this.i, c)
			} catch(Qa) {}
		}
		return this.h
	};

	function ld(a) {
		var b = a.toString();
		a.name && -1 == b.indexOf(a.name) && (b += ": " + a.name);
		a.message && -1 == b.indexOf(a.message) && (b += ": " + a.message);
		if(a.stack) {
			a = a.stack;
			var c = b;
			try {
				-1 == a.indexOf(c) && (a = c + "\n" + a);
				for(var d; a != d;) d = a, a = a.replace(/((https?:\/..*\/)[^\/:]*:\d+(?:.|\n)*)\2/, "$1");
				b = a.replace(/\n */g, "\n")
			} catch(e) {
				b = c
			}
		}
		return b
	}

	function kd(a, b, c) {
		Jc.call(this, Error(a), {
			message: a,
			file: void 0 === b ? "" : b,
			line: void 0 === c ? -1 : c
		})
	}
	ia(kd, Jc);

	function L(a) {
		a = void 0 === a ? "" : a;
		var b = Error.call(this);
		this.message = b.message;
		"stack" in b && (this.stack = b.stack);
		this.name = "TagError";
		this.message = a ? "adsbygoogle.push() error: " + a : "";
		Error.captureStackTrace ? Error.captureStackTrace(this, L) : this.stack = Error().stack || ""
	}
	ia(L, Error);

	function nd(a) {
		return 0 == (a.error && a.meta && a.id ? a.msg || ld(a.error) : ld(a)).indexOf("TagError")
	};
	var id, K, ed = nc(),
		hd = new dd;

	function od(a) {
		null != a && (ed.google_measure_js_timing = a);
		ed.google_measure_js_timing || (a = hd, a.a = !1, a.b != a.g.google_js_reporting_queue && (cd() && Ca(a.b, fd), a.b.length = 0))
	}
	id = new function() {
		var a = void 0 === a ? C : a;
		this.h = "http:" === a.location.protocol ? "http:" : "https:";
		this.b = "pagead2.googlesyndication.com";
		this.g = "/pagead/gen_204?id=";
		this.a = .01;
		this.i = Math.random()
	};
	K = new gd;
	"complete" == ed.document.readyState ? od() : hd.a && Tb(ed, "load", function() {
		od()
	});

	function pd() {
		var a = [qd, rd];
		K.g = function(b) {
			Ca(a, function(a) {
				a(b)
			})
		}
	}

	function sd(a, b, c, d) {
		return jd(K, a, c, d, b)
	}

	function td(a, b) {
		return md(a, b)
	}
	var ud = K.a;

	function vd(a, b, c) {
		Uc(id, a, b, "jserror" != a, c, void 0)
	}

	function wd(a, b, c, d) {
		return nd(b) ? (K.i = !0, K.a(a, b, .1, d, "puberror"), !1) : K.a(a, b, c, d)
	}

	function xd(a, b, c, d) {
		return nd(b) ? !1 : K.a(a, b, c, d)
	};

	function yd(a, b) {
		this.U = a;
		this.aa = b
	}

	function zd(a) {
		var b = [].slice.call(arguments).filter(kb());
		if(!b.length) return null;
		var c = [],
			d = {};
		b.forEach(function(a) {
			c = c.concat(a.U || []);
			d = Object.assign(d, a.aa)
		});
		return new yd(c, d)
	};
	var Ad = new yd(["google-auto-placed"], {
		google_tag_origin: "qs"
	});

	function Bd(a, b) {
		a.location.href && a.location.href.substring && (b.url = a.location.href.substring(0, 200));
		vd("ama", b, .01)
	};

	function Cd(a, b, c) {
		c || (c = cc ? "https" : "http");
		r.location && "https:" == r.location.protocol && "http" == c && (c = "https");
		return [c, "://", a, b].join("")
	};
	var Dd = null;

	function Ed() {
		if(!$b) return !1;
		if(null != Dd) return Dd;
		Dd = !1;
		try {
			var a = G(r);
			a && -1 != a.location.hash.indexOf("google_logging") && (Dd = !0);
			r.localStorage.getItem("google_logging") && (Dd = !0)
		} catch(b) {}
		return Dd
	}

	function Fd(a, b) {
		b = void 0 === b ? [] : b;
		if(Ed()) {
			if(!r.google_logging_queue) {
				r.google_logging_queue = [];
				var c = Cd(ec(), "/pagead/js/logging_library.js");
				Eb(r.document, c)
			}
			r.google_logging_queue.push([a, b])
		}
	};

	function Gd(a) {
		A(this, a, null)
	}
	w(Gd, z);
	var Hd = null;

	function Id() {
		if(!Hd) {
			for(var a = r, b = a, c = 0; a && a != a.parent;)
				if(a = a.parent, c++, D(a)) b = a;
				else break;
			Hd = b
		}
		return Hd
	};
	var Jd = {
			c: "368226950",
			f: "368226951"
		},
		Kd = {
			c: "368226960",
			f: "368226961"
		},
		Ld = {
			c: "368226500",
			f: "368226501"
		},
		Md = {
			c: "36998750",
			f: "36998751"
		},
		Nd = {
			c: "633794000",
			f: "633794001"
		},
		Od = {
			c: "633794002",
			f: "633794003"
		},
		Pd = {
			c: "4089040",
			ka: "4089042"
		},
		Qd = {
			m: "20040067",
			c: "20040068",
			L: "1337"
		},
		Rd = {
			c: "21060548",
			m: "21060549"
		},
		Sd = {
			c: "21060623",
			m: "21060624"
		},
		Td = {
			c: "22324606",
			f: "22324607"
		},
		Ud = {
			c: "21062271",
			m: "21062272"
		},
		Vd = {
			F: "62710015",
			c: "62710016"
		},
		Wd = {
			c: "21070026",
			C: "21070027"
		},
		Xd = {
			c: "21060518",
			f: "21060519"
		},
		Yd = {
			c: "21060849",
			O: "21060850",
			G: "21060851",
			N: "21060852",
			M: "21060853"
		},
		Zd = {
			c: "21061394",
			f: "21061395"
		},
		$d = {
			c: "182982000",
			f: "182982100"
		},
		ae = {
			c: "182982200",
			f: "182982300"
		},
		be = {
			c: "182983000",
			f: "182983100"
		},
		ce = {
			c: "182983200",
			f: "182983300"
		},
		de = {
			c: "182984000",
			f: "182984100"
		},
		ee = {
			c: "182984200",
			f: "182984300"
		},
		fe = {
			c: "10583695",
			f: "10583696"
		},
		ge = {
			c: "10593695",
			f: "10593696"
		},
		he = {
			c: "10573695",
			ia: "10573696",
			ja: "10573697"
		},
		ie = {
			c: "20195145",
			f: "20195146"
		},
		je = {
			c: "21062569",
			f: "21062570"
		},
		ke = {
			c: "214678000",
			f: "214678100"
		};
	var le = {
			google: 1,
			googlegroups: 1,
			gmail: 1,
			googlemail: 1,
			googleimages: 1,
			googleprint: 1
		},
		me = /(corp|borg)\.google\.com:\d+$/;

	function ne() {
		var a = C.google_page_location || C.google_page_url;
		"EMPTY" == a && (a = C.google_page_url);
		if($b || !a) return !1;
		a = a.toString();
		0 == a.indexOf("http://") ? a = a.substring(7, a.length) : 0 == a.indexOf("https://") && (a = a.substring(8, a.length));
		var b = a.indexOf("/"); - 1 == b && (b = a.length);
		a = a.substring(0, b);
		if(me.test(a)) return !1;
		a = a.split(".");
		b = !1;
		3 <= a.length && (b = a[a.length - 3] in le);
		2 <= a.length && (b = b || a[a.length - 2] in le);
		return b
	};

	function oe(a) {
		this.a = this.b = null;
		"function" == ta(a) ? this.a = a : this.b = a
	}
	oe.prototype.getVerifier = function(a) {
		return this.b ? this.b[a] : null
	};
	oe.prototype.getSchema = function(a) {
		return this.a ? this.a(a) : null
	};
	oe.prototype.doesReturnAnotherSchema = function() {
		return this.a ? !0 : !1
	};

	function pe() {
		this.wasPlaTagProcessed = !1;
		this.wasReactiveAdConfigReceived = {};
		this.adCount = {};
		this.wasReactiveAdVisible = {};
		this.stateForType = {};
		this.reactiveTypeEnabledInAsfe = {};
		this.isReactiveTagFirstOnPage = this.wasReactiveAdConfigHandlerRegistered = this.wasReactiveTagRequestSent = !1;
		this.reactiveTypeDisabledByPublisher = {};
		this.tagSpecificState = {};
		this.messageValidationEnabled = !1;
		this.adRegion = this.floatingAdsFillMessage = null;
		this.disablePageHeightCheck = !1;
		this.improveCollisionDetection = 0
	}

	function qe(a) {
		a.google_reactive_ads_global_state || (a.google_reactive_ads_global_state = new pe);
		return a.google_reactive_ads_global_state
	};

	function re(a) {
		a = a.document;
		var b = {};
		a && (b = "CSS1Compat" == a.compatMode ? a.documentElement : a.body);
		return b || {}
	}

	function M(a) {
		return re(a).clientWidth
	};

	function se(a, b) {
		for(var c = [], d = a.length, e = 0; e < d; e++) c.push(a[e]);
		c.forEach(b, void 0)
	};

	function te(a, b, c, d) {
		this.h = a;
		this.b = b;
		this.g = c;
		this.a = d
	}
	te.prototype.toString = function() {
		return JSON.stringify({
			nativeQuery: this.h,
			occurrenceIndex: this.b,
			paragraphIndex: this.g,
			ignoreMode: this.a
		})
	};

	function ue(a, b) {
		if(null == a.a) return b;
		switch(a.a) {
			case 1:
				return b.slice(1);
			case 2:
				return b.slice(0, b.length - 1);
			case 3:
				return b.slice(1, b.length - 1);
			case 0:
				return b;
			default:
				throw Error("Unknown ignore mode: " + a.a);
		}
	}

	function ve(a) {
		var b = [];
		se(a.getElementsByTagName("p"), function(a) {
			100 <= we(a) && b.push(a)
		});
		return b
	}

	function we(a) {
		if(3 == a.nodeType) return a.length;
		if(1 != a.nodeType || "SCRIPT" == a.tagName) return 0;
		var b = 0;
		se(a.childNodes, function(a) {
			b += we(a)
		});
		return b
	}

	function xe(a) {
		return 0 == a.length || isNaN(a[0]) ? a : "\\" + (30 + parseInt(a[0], 10)) + " " + a.substring(1)
	};
	var ye = {
		rectangle: 1,
		horizontal: 2,
		vertical: 4
	};

	function ze(a, b) {
		for(var c = ["width", "height"], d = 0; d < c.length; d++) {
			var e = "google_ad_" + c[d];
			if(!b.hasOwnProperty(e)) {
				var f = F(a[c[d]]);
				f = null === f ? null : Math.round(f);
				null != f && (b[e] = f)
			}
		}
	}

	function Ae(a, b) {
		return !((Kb.test(b.google_ad_width) || Jb.test(a.style.width)) && (Kb.test(b.google_ad_height) || Jb.test(a.style.height)))
	}

	function Be(a, b) {
		try {
			var c = b.document.documentElement.getBoundingClientRect(),
				d = a.getBoundingClientRect();
			var e = {
				x: d.left - c.left,
				y: d.top - c.top
			}
		} catch(f) {
			e = null
		}
		return(a = e) ? a.y : 0
	}

	function Ce(a, b) {
		do {
			var c = E(a, b);
			if(c && "fixed" == c.position) return !1
		} while (a = a.parentElement);
		return !0
	}

	function De(a) {
		var b = 0,
			c;
		for(c in ye) - 1 != a.indexOf(c) && (b |= ye[c]);
		return b
	}

	function Ee(a, b, c, d, e) {
		if(pc(a) != a) return G(a) ? 3 : 16;
		if(!(488 > M(a))) return 4;
		if(!(a.innerHeight >= a.innerWidth)) return 5;
		var f = M(a);
		if(!f || (f - c) / f > d) a = 6;
		else {
			if(c = "true" != e.google_full_width_responsive) a: {
				c = M(a);
				for(b = b.parentElement; b; b = b.parentElement)
					if((d = E(b, a)) && (e = F(d.width)) && !(e >= c) && "visible" != d.overflow) {
						c = !0;
						break a
					}
				c = !1
			}
			a = c ? 7 : !0
		}
		return a
	}

	function Fe(a, b, c, d) {
		var e = Ee(b, c, a, .3, d);
		if(!0 !== e) return e;
		e = M(b);
		a = e - a;
		a = e && 0 <= a ? !0 : e ? -10 > a ? 11 : 0 > a ? 14 : 12 : 10;
		return "true" == d.google_full_width_responsive || Ce(c, b) ? a : 9
	}

	function Ge(a, b) {
		if(3 == b.nodeType) return /\S/.test(b.data);
		if(1 == b.nodeType) {
			if(/^(script|style)$/i.test(b.nodeName)) return !1;
			try {
				var c = E(b, a)
			} catch(d) {}
			return !c || "none" != c.display && !("absolute" == c.position && ("hidden" == c.visibility || "collapse" == c.visibility))
		}
		return !1
	}

	function He(a, b, c, d, e, f) {
		if(a = E(c, a)) {
			var g = F(a.paddingLeft) || 0;
			a = a.direction;
			d = e - d;
			if(f.google_ad_resize) g = -1 * (d + g) + "px";
			else {
				for(var h = f = 0; 100 > h && c; h++) f += c.offsetLeft + c.clientLeft - c.scrollLeft, c = c.offsetParent;
				g = f + g;
				g = "rtl" == a ? -1 * (d - g) + "px" : -1 * g + "px"
			}
			"rtl" == a ? b.style.marginRight = g : b.style.marginLeft = g;
			b.style.width = e + "px";
			b.style.zIndex = 30
		}
	};

	function N(a, b) {
		this.b = a;
		this.a = b
	}
	l = N.prototype;
	l.minWidth = function() {
		return this.b
	};
	l.height = function() {
		return this.a
	};
	l.s = function(a) {
		return 300 < a && 300 < this.a ? this.b : Math.min(1200, Math.round(a))
	};
	l.H = function(a) {
		return this.s(a) + "x" + this.height()
	};
	l.D = function() {};

	function O(a, b, c, d) {
		d = void 0 === d ? function(a) {
			return a
		} : d;
		var e;
		return a.style && a.style[c] && d(a.style[c]) || (e = E(a, b)) && e[c] && d(e[c]) || null
	}

	function Ie(a) {
		return function(b) {
			return b.minWidth() <= a
		}
	}

	function Je(a, b, c, d) {
		var e = a && Ke(c, b),
			f = Le(b, d);
		return function(a) {
			return !(e && a.height() >= f)
		}
	}

	function Me(a) {
		return function(b) {
			return b.height() <= a
		}
	}

	function Ke(a, b) {
		return Be(a, b) < re(b).clientHeight - 100
	}

	function Ne(a, b) {
		var c = Infinity;
		do {
			var d = O(b, a, "height", F);
			d && (c = Math.min(c, d));
			(d = O(b, a, "maxHeight", F)) && (c = Math.min(c, d))
		} while ((b = b.parentElement) && "HTML" != b.tagName);
		return c
	}

	function Oe(a, b) {
		var c = O(b, a, "height", F);
		if(c) return c;
		var d = b.style.height;
		b.style.height = "inherit";
		c = O(b, a, "height", F);
		b.style.height = d;
		if(c) return c;
		c = Infinity;
		do(d = b.style && F(b.style.height)) && (c = Math.min(c, d)), (d = O(b, a, "maxHeight", F)) && (c = Math.min(c, d)); while ((b = b.parentElement) && "HTML" != b.tagName);
		return c
	}

	function Le(a, b) {
		var c = a.google_unique_id;
		return b && 0 == ("number" === typeof c ? c : 0) ? Math.max(250, 2 * re(a).clientHeight / 3) : 250
	};

	function Pe(a) {
		if(1 != a.nodeType) var b = !1;
		else if(b = "INS" == a.tagName) a: {
			b = ["adsbygoogle-placeholder"];a = a.className ? a.className.split(/\s+/) : [];
			for(var c = {}, d = 0; d < a.length; ++d) c[a[d]] = !0;
			for(d = 0; d < b.length; ++d)
				if(!c[b[d]]) {
					b = !1;
					break a
				}
			b = !0
		}
		return b
	};

	function Qe(a, b) {
		for(var c = 0; c < b.length; c++) {
			var d = b[c],
				e = Sa(d.Na);
			a[e] = d.value
		}
	};
	var Re = {
		1: 1,
		2: 2,
		3: 3,
		0: 0
	};

	function Se(a) {
		return null != a ? Re[a] : a
	}
	var Te = {
		1: 0,
		2: 1,
		3: 2,
		4: 3
	};

	function Ue(a, b) {
		if(!a) return !1;
		a = E(a, b);
		if(!a) return !1;
		a = a.cssFloat || a.styleFloat;
		return "left" == a || "right" == a
	}

	function Ve(a) {
		for(a = a.previousSibling; a && 1 != a.nodeType;) a = a.previousSibling;
		return a ? a : null
	}

	function We(a) {
		return !!a.nextSibling || !!a.parentNode && We(a.parentNode)
	};

	function Xe(a, b, c) {
		this.a = r;
		this.i = a;
		this.h = b;
		this.g = c || null;
		this.b = !1
	}

	function Ye(a, b) {
		if(a.b) return !0;
		try {
			var c = a.a.localStorage.getItem("google_ama_settings");
			var d = c ? new Gd(c ? JSON.parse(c) : null) : null
		} catch(h) {
			d = null
		}
		if(c = null !== d) d = B(d, 2), c = null == d ? !1 : d;
		if(c) return a = a.a.google_ama_state = a.a.google_ama_state || {}, a.eatf = !0, Fd(7, [!0, 0, !1]), !0;
		d = 0;
		var e = cb(a.h, Bc, 1);
		for(c = 0; c < e.length; c++) {
			var f = e[c];
			if(1 == B(f, 8)) {
				var g = bb(f, Ac, 4);
				if(g && 2 == B(g, 1) && (d++, Ze(a, f, b))) return a.b = !0, a = a.a.google_ama_state = a.a.google_ama_state || {}, a.placement = c, Fd(7, [!1, d, !0]), !0
			}
		}
		Fd(7, [!1, d, !1]);
		return !1
	}

	function Ze(a, b, c) {
		if(1 != B(b, 8)) return !1;
		var d = bb(b, wc, 1);
		if(!d) return !1;
		var e = B(d, 7);
		if(B(d, 1) || B(d, 3) || 0 < ab(d, 4).length) {
			var f = B(d, 3),
				g = B(d, 1),
				h = ab(d, 4);
			e = B(d, 2);
			var k = B(d, 5);
			d = Se(B(d, 6));
			var m = "";
			g && (m += g);
			f && (m += "#" + xe(f));
			if(h)
				for(f = 0; f < h.length; f++) m += "." + xe(h[f]);
			e = (h = m) ? new te(h, e, k, d) : null
		} else e = e ? new te(e, B(d, 2), B(d, 5), Se(B(d, 6))) : null;
		if(!e) return !1;
		k = [];
		try {
			k = a.a.document.querySelectorAll(e.h)
		} catch(q) {}
		if(k.length) {
			h = k.length;
			if(0 < h) {
				d = Array(h);
				for(f = 0; f < h; f++) d[f] = k[f];
				k = d
			} else k = [];
			k = ue(e, k);
			v(e.b) && (h = e.b, 0 > h && (h += k.length), k = 0 <= h && h < k.length ? [k[h]] : []);
			if(v(e.g)) {
				h = [];
				for(d = 0; d < k.length; d++) f = ve(k[d]), g = e.g, 0 > g && (g += f.length), 0 <= g && g < f.length && h.push(f[g]);
				k = h
			}
			e = k
		} else e = [];
		if(0 == e.length) return !1;
		e = e[0];
		k = B(b, 2);
		k = Te[k];
		k = void 0 !== k ? k : null;
		if(!(h = null == k)) {
			a: {
				h = a.a;
				switch(k) {
					case 0:
						h = Ue(Ve(e), h);
						break a;
					case 3:
						h = Ue(e, h);
						break a;
					case 2:
						d = e.lastChild;
						h = Ue(d ? 1 == d.nodeType ? d : Ve(d) : null, h);
						break a
				}
				h = !1
			}
			if(c = !h && !(!c && 2 == k && !We(e))) c = 1 == k || 2 == k ? e : e.parentNode,
			c = !(c && !Pe(c) && 0 >= c.offsetWidth);h = !c
		}
		if(h) return !1;
		b = bb(b, zc, 3);
		h = {};
		b && (h.ga = B(b, 1), h.R = B(b, 2), h.oa = !!B(b, 3));
		b = a.a;
		c = a.g;
		d = a.i;
		f = b.document;
		a = wb(new vb(f), "DIV");
		g = a.style;
		g.textAlign = "center";
		g.width = "100%";
		g.height = "auto";
		g.clear = h.oa ? "both" : "none";
		h.ua && Qe(g, h.ua);
		f = wb(new vb(f), "INS");
		g = f.style;
		g.display = "block";
		g.margin = "auto";
		g.backgroundColor = "transparent";
		h.ga && (g.marginTop = h.ga);
		h.R && (g.marginBottom = h.R);
		h.na && Qe(g, h.na);
		a.appendChild(f);
		f.setAttribute("data-ad-format", "auto");
		h = [];
		if(g = c && c.U) a.className = g.join(" ");
		f.className = "adsbygoogle";
		f.setAttribute("data-ad-client", d);
		h.length && f.setAttribute("data-ad-channel", h.join("+"));
		a: {
			try {
				switch(k) {
					case 0:
						e.parentNode && e.parentNode.insertBefore(a, e);
						break;
					case 3:
						var n = e.parentNode;
						if(n) {
							var p = e.nextSibling;
							if(p && p.parentNode != n)
								for(; p && 8 == p.nodeType;) p = p.nextSibling;
							n.insertBefore(a, p)
						}
						break;
					case 1:
						e.insertBefore(a, e.firstChild);
						break;
					case 2:
						e.appendChild(a)
				}
				Pe(e) && (e.setAttribute("data-init-display", e.style.display), e.style.display = "block");
				b: {
					f.setAttribute("data-adsbygoogle-status", "reserved");f.className += " adsbygoogle-noablate";n = {
						element: f
					};
					var u = c && c.aa;
					if(f.hasAttribute("data-pub-vars")) {
						try {
							u = JSON.parse(f.getAttribute("data-pub-vars"))
						} catch(q) {
							break b
						}
						f.removeAttribute("data-pub-vars")
					}
					u && (n.params = u);
					(b.adsbygoogle = b.adsbygoogle || []).push(n)
				}
			} catch(q) {
				a && a.parentNode && (u = a.parentNode, u.removeChild(a), Pe(u) && (u.style.display = u.getAttribute("data-init-display") || "none"));
				u = !1;
				break a
			}
			u = !0
		}
		return u ? !0 : !1
	};

	function $e() {
		this.b = new af(this);
		this.a = 0
	}

	function bf(a) {
		if(0 != a.a) throw Error("Already resolved/rejected.");
	}

	function af(a) {
		this.a = a
	}

	function cf(a) {
		switch(a.a.a) {
			case 0:
				break;
			case 1:
				a.b && a.b(a.a.h);
				break;
			case 2:
				a.g && a.g(a.a.g);
				break;
			default:
				throw Error("Unhandled deferred state.");
		}
	};

	function df(a) {
		this.exception = a
	}

	function ef(a, b) {
		this.b = r;
		this.g = a;
		this.a = b
	}
	ef.prototype.start = function() {
		this.h()
	};
	ef.prototype.h = function() {
		try {
			switch(this.b.document.readyState) {
				case "complete":
				case "interactive":
					Ye(this.g, !0);
					ff(this);
					break;
				default:
					Ye(this.g, !1) ? ff(this) : this.b.setTimeout(ya(this.h, this), 100)
			}
		} catch(a) {
			ff(this, a)
		}
	};

	function ff(a, b) {
		try {
			var c = a.a,
				d = new df(b);
			bf(c);
			c.a = 1;
			c.h = d;
			cf(c.b)
		} catch(e) {
			a = a.a, b = e, bf(a), a.a = 2, a.g = b, cf(a.b)
		}
	};

	function gf(a) {
		Bd(a, {
			atf: 1
		})
	}

	function hf(a, b) {
		(a.google_ama_state = a.google_ama_state || {}).exception = b;
		Bd(a, {
			atf: 0
		})
	};

	function jf() {
		this.debugCard = null;
		this.debugCardRequested = !1
	};

	function kf(a, b) {
		if(!a) return !1;
		a = a.hash;
		if(!a || !a.indexOf) return !1;
		if(-1 != a.indexOf(b)) return !0;
		b = lf(b);
		return "go" != b && -1 != a.indexOf(b) ? !0 : !1
	}

	function lf(a) {
		var b = "";
		hc(a.split("_"), function(a) {
			b += a.substr(0, 2)
		});
		return b
	};
	(function(a) {
		function b(a) {
			a.o && (c[a.name] = a.o)
		}
		var c = {
			msg_type: /^[a-zA-Z0-9_-]+$/
		};
		hc(uc, b);
		for(var d = 0; d < vc.length; d++) b(vc[d]);
		for(d = 0; d < a.length; d++) b(a[d]);
		return new oe(c)
	})([]);
	var mf = {
		9: "400",
		10: "100",
		11: "0.10",
		13: "0.001",
		19: "0.01",
		22: "0.01",
		23: "0.2",
		24: "0.05",
		27: "0.001",
		28: "0.001",
		29: "0.01",
		34: "0.001",
		37: "0.0",
		40: "0.15",
		47: "0.01",
		56: "0.001",
		60: "0.03",
		66: "0.0",
		67: "0.04",
		76: "0.004",
		77: "true",
		78: "0.1",
		79: "1200",
		82: "3",
		83: "1.0",
		92: "0.02",
		96: "700",
		97: "10",
		98: "0.01",
		99: "600",
		100: "100",
		103: "0.01",
		111: "0.1",
		112: "0",
		117: "0.02",
		118: "false",
		120: "0",
		121: "1000",
		126: "0.001",
		127: "0.1",
		128: "false",
		129: "0.02",
		135: "0.0",
		136: "0.02",
		137: "0.01",
		141: "0.1",
		142: "1",
		143: "0.06",
		146: "0.10",
		148: "0.02",
		149: "0",
		150: "1000",
		151: "0.02",
		152: "700",
		153: "20",
		154: "0.001",
		155: "0.03",
		156: "0.02",
		157: "800",
		158: "20"
	};
	var nf = null;

	function of () {
		this.a = mf
	}

	function P(a, b) {
		a = parseFloat(a.a[b]);
		return isNaN(a) ? 0 : a
	}

	function pf() {
		nf || (nf = new of );
		return nf
	};

	function qf(a, b, c, d, e) {
		d = void 0 === d ? "" : d;
		var f = a.createElement("link");
		try {
			f.rel = c;
			if(x(c.toLowerCase(), "stylesheet")) var g = pb(b);
			else {
				if(b instanceof nb) var h = pb(b);
				else {
					if(b instanceof qb)
						if(b instanceof qb && b.constructor === qb && b.la === rb) var k = b.J;
						else ta(b), k = "type_error:SafeUrl";
					else {
						if(b instanceof qb) var m = b;
						else b = "object" == typeof b && b.g ? b.a() : String(b), sb.test(b) || (b = "about:invalid#zClosurez"), m = tb(b);
						k = m.a()
					}
					h = k
				}
				g = h
			}
			f.href = g
		} catch(n) {
			return
		}
		d && "preload" == c && (f.as = d);
		e && (f.nonce = e);
		if(a = a.getElementsByTagName("head")[0]) try {
			a.appendChild(f)
		} catch(n) {}
	};

	function rf(a) {
		var b = {},
			c = {};
		a = (c.enable_page_level_ads = (b.pltais = !0, b), c.google_ad_client = a, c);
		a.enable_page_level_ads.google_ad_channel = "AutoInsertAutoAdCode";
		return a
	};

	function sf(a, b) {
		function c(a) {
			try {
				var b = new eb(a);
				return Ea(cb(b, gb, 2), function(a) {
					return 1 == B(a, 1)
				})
			} catch(f) {
				return null
			}
		}
		b = void 0 === b ? "" : b;
		a = G(a) || a;
		a = tf(a);
		return b ? a[b] ? c(a[b]) : null : Ea(Da(Wa(a), c), function(a) {
			return null != a
		})
	}

	function uf(a, b, c) {
		function d(a) {
			if(!a) return !1;
			a = new eb(a);
			var c;
			if(c = ab(a, 3)) a = ab(a, 3), c = 0 <= Ba(a, b);
			return c
		}
		c = void 0 === c ? "" : c;
		a = G(a) || a;
		if(vf(a, b)) return !0;
		a = tf(a);
		return c ? d(a[c]) : Va(a, d)
	}

	function vf(a, b) {
		a = (a = (a = a.location && a.location.hash) && a.match(/forced_clientside_labs=([\d,]+)/)) && a[1];
		return !!a && 0 <= Ba(a.split(","), b.toString())
	}

	function tf(a) {
		try {
			return Qb({}, JSON.parse(a.localStorage.getItem("google_adsense_settings")))
		} catch(b) {
			return {}
		}
	};

	function wf(a) {
		if(r.google_apltlad || pc(r) != r) return !1;
		if(kf(r.location, "google_ads_preview")) return !0;
		if(!uf(r, 12, a.google_ad_client) || "google_ad_host" in a) return !1;
		r.google_apltlad = !0;
		return I(r, Jd.f)
	};

	function rd(a) {
		try {
			var b = r.google_ad_modifications;
			if(null != b) {
				var c = Fa(b.eids, b.loeids);
				null != c && 0 < c.length && (a.eid = c.join(","))
			}
		} catch(d) {}
	}

	function qd(a) {
		a.shv = Zb()
	}
	K.h = !$b;
	var xf = new Wc(400, 499),
		yf = new Wc(600, 699),
		zf = new Wc(700, 799),
		Af = new Wc(800, 899);

	function Q(a, b) {
		b && a.push(b)
	}

	function Bf(a, b) {
		for(var c = [], d = 1; d < arguments.length; ++d) c[d - 1] = arguments[d];
		d = G(a) || a;
		d = (d = (d = d.location && d.location.hash) && (d.match(/google_plle=([\d,]+)/) || d.match(/deid=([\d,]+)/))) && d[1];
		var e;
		if(e = !!d) a: {
			d = za(x, d);e = c.length;
			for(var f = t(c) ? c.split("") : c, g = 0; g < e; g++)
				if(g in f && d.call(void 0, f[g], g, c)) {
					e = !0;
					break a
				}
			e = !1
		}
		return e
	}

	function R(a, b, c) {
		for(var d = 0; d < c.length; d++)
			if(Bf(a, c[d])) return c[d];
		a: {
			if(!Ib() && (a = Math.random(), a < b)) {
				a = Fb(r);
				b = c[Math.floor(a * c.length)];
				break a
			}
			b = null
		}
		return b
	}

	function Cf(a, b, c, d, e, f) {
		f = void 0 === f ? 1 : f;
		for(var g = 0; g < e.length; g++)
			if(Bf(a, e[g])) return e[g];
		f = void 0 === f ? 1 : f;
		0 >= d ? c = null : (g = new Vc(c, c + d - 1), (d = d % f || d / f % e.length) || (b = b.a, d = !(b.start <= g.start && b.a >= g.a)), d ? c = null : (a = Xc(a), c = null !== a && g.start <= a && g.a >= a ? e[Math.floor((a - c) / f) % e.length] : null));
		return c
	};

	function Df(a) {
		if(!a) return "";
		(a = a.toLowerCase()) && "ca-" != a.substring(0, 3) && (a = "ca-" + a);
		return a
	};

	function Ef(a, b, c, d) {
		d = void 0 === d ? "" : d;
		var e = void 0 === e ? "" : e;
		var f = ["<iframe"],
			g;
		for(g in a) a.hasOwnProperty(g) && f.push(g + "=" + a[g]);
		f.push('style="' + ("left:0;position:absolute;top:0;width:" + b + "px;height:" + c + "px;") + '"');
		f.push("></iframe>");
		a = a.id;
		e = void 0 === e ? "" : e;
		b = "border:none;height:" + c + "px;margin:0;padding:0;" + ("position:relative;visibility:visible;width:" + b + "px;") + "background-color:transparent;";
		return ['<ins id="' + (a + "_expand") + '"', ' style="display:inline-table;' + b + (void 0 === d ? "" : d) + '"', e ? ' data-ad-slot="' + e + '">' : ">", '<ins id="' + (a + "_anchor") + '" style="display:block;' + b + '">', f.join(" "), "</ins></ins>"].join("")
	}

	function Ff(a, b, c) {
		if(D(a.document.getElementById(b).contentWindow)) a = a.document.getElementById(b).contentWindow, b = a.document, b.body && b.body.firstChild || (/Firefox/.test(navigator.userAgent) ? b.open("text/html", "replace") : b.open(), a.google_async_iframe_close = !0, b.write(c));
		else {
			a = a.document.getElementById(b).contentWindow;
			c = String(c);
			b = ['"'];
			for(var d = 0; d < c.length; d++) {
				var e = c.charAt(d),
					f = e.charCodeAt(0),
					g = d + 1,
					h;
				if(!(h = Pa[e])) {
					if(!(31 < f && 127 > f))
						if(f = e, f in Ra) e = Ra[f];
						else if(f in Pa) e = Ra[f] = Pa[f];
					else {
						h = f.charCodeAt(0);
						if(31 < h && 127 > h) e = f;
						else {
							if(256 > h) {
								if(e = "\\x", 16 > h || 256 < h) e += "0"
							} else e = "\\u", 4096 > h && (e += "0");
							e += h.toString(16).toUpperCase()
						}
						e = Ra[f] = e
					}
					h = e
				}
				b[g] = h
			}
			b.push('"');
			a.location.replace("javascript:" + b.join(""))
		}
	};
	var Gf = null;

	function S(a, b, c, d) {
		d = void 0 === d ? !1 : d;
		N.call(this, a, b);
		this.B = c;
		this.sa = d
	}
	ia(S, N);
	S.prototype.K = function() {
		return this.B
	};
	S.prototype.D = function(a, b, c, d) {
		1 != c.google_ad_resize && (d.style.height = this.height() + "px", I(a, ke.c) ? (c.rpe = !1, c.ovlp = !0) : I(a, ke.f) && (c.rpe = !0, c.ovlp = !0))
	};

	function Hf(a) {
		return function(b) {
			return !!(b.B & a)
		}
	};

	function T(a, b, c, d, e, f, g, h, k, m, n) {
		this.Ea = a;
		this.a = b;
		this.B = void 0 === c ? null : c;
		this.ea = void 0 === d ? null : d;
		this.b = void 0 === e ? null : e;
		this.g = void 0 === f ? null : f;
		this.Y = void 0 === g ? null : g;
		this.Z = void 0 === h ? null : h;
		this.h = void 0 === k ? null : k;
		this.i = void 0 === m ? null : m;
		this.$ = void 0 === n ? null : n;
		this.ha = this.A = this.w = null
	}

	function If(a, b, c) {
		null != a.B && (c.google_responsive_formats = a.B);
		null != a.ea && (c.google_safe_for_responsive_override = a.ea);
		null != a.b && (!0 === a.b ? c.google_full_width_responsive_allowed = !0 : (c.google_full_width_responsive_allowed = !1, c.gfwrnwer = a.b));
		null != a.g && !0 !== a.g && (c.gfwrnher = a.g);
		var d = a.a.s(b),
			e = a.a.height();
		1 != c.google_ad_resize && (c.google_ad_width = d, c.google_ad_height = e, c.google_ad_format = a.a.H(b), c.google_responsive_auto_format = a.Ea, c.google_ad_resizable = !0, c.google_override_format = 1, c.google_loader_features_used = 128, !0 === a.b && (c.gfwrnh = a.a.height() + "px"));
		null != a.Y && (c.gfwroml = a.Y);
		null != a.Z && (c.gfwromr = a.Z);
		null != a.h && (c.gfwroh = a.h, c.google_resizing_height = a.h);
		null != a.i && (c.gfwrow = a.i, c.google_resizing_width = a.i);
		null != a.$ && (c.gfwroz = a.$);
		null != a.w && (c.gml = a.w);
		null != a.A && (c.gmr = a.A);
		null != a.ha && (c.gzi = a.ha);
		b = nc();
		b = G(b) || b;
		if(kf(b.location, "google_responsive_slot_debug") || Bf(b, $d.c, $d.f)) c.ds = "outline:thick dashed " + (d && e ? !0 !== a.b || !0 !== a.g ? "#ffa500" : "#0f0" : "#f00") + " !important;"
	};
	var Jf = ["google_content_recommendation_ui_type", "google_content_recommendation_columns_num", "google_content_recommendation_rows_num"],
		Kf = {},
		Lf = (Kf.image_stacked = 1 / 1.91, Kf.image_sidebyside = 1 / 3.82, Kf.mobile_banner_image_sidebyside = 1 / 3.82, Kf.pub_control_image_stacked = 1 / 1.91, Kf.pub_control_image_sidebyside = 1 / 3.82, Kf.pub_control_image_card_stacked = 1 / 1.91, Kf.pub_control_image_card_sidebyside = 1 / 3.74, Kf.pub_control_text = 0, Kf.pub_control_text_card = 0, Kf),
		Mf = {},
		Nf = (Mf.image_stacked = 80, Mf.image_sidebyside = 0, Mf.mobile_banner_image_sidebyside = 0, Mf.pub_control_image_stacked = 80, Mf.pub_control_image_sidebyside = 0, Mf.pub_control_image_card_stacked = 85, Mf.pub_control_image_card_sidebyside = 0, Mf.pub_control_text = 80, Mf.pub_control_text_card = 80, Mf),
		Of = {},
		Pf = (Of.pub_control_image_stacked = 100, Of.pub_control_image_sidebyside = 200, Of.pub_control_image_card_stacked = 150, Of.pub_control_image_card_sidebyside = 250, Of.pub_control_text = 100, Of.pub_control_text_card = 150, Of);

	function Qf(a, b) {
		N.call(this, a, b)
	}
	ia(Qf, N);
	Qf.prototype.s = function(a) {
		return Math.min(1200, Math.max(this.minWidth(), Math.round(a)))
	};

	function Rf(a) {
		var b = 0;
		hc(Jf, function(c) {
			null != a[c] && ++b
		});
		if(0 === b) return !1;
		if(b === Jf.length) return !0;
		throw new L("Tags data-matched-content-ui-type, data-matched-content-columns-num and data-matched-content-rows-num should be set together.");
	}

	function Sf(a, b) {
		Tf(a, b);
		if(a < Yb) {
			if(zb()) {
				Uf(b, "mobile_banner_image_sidebyside", 1, 12);
				var c = +b.google_content_recommendation_columns_num;
				c = (a - 8 * c - 8) / c;
				var d = b.google_content_recommendation_ui_type;
				b = b.google_content_recommendation_rows_num - 1;
				return new T(9, new Qf(a, Math.floor(c / 1.91 + 70) + Math.floor((c * Lf[d] + Nf[d]) * b + 8 * b + 8)))
			}
			Uf(b, "image_sidebyside", 1, 13);
			return new T(9, Vf(a))
		}
		Uf(b, "image_stacked", 4, 2);
		return new T(9, Vf(a))
	}

	function Vf(a) {
		return 1200 <= a ? new Qf(1200, 600) : 850 <= a ? new Qf(a, Math.floor(.5 * a)) : 550 <= a ? new Qf(a, Math.floor(.6 * a)) : 468 <= a ? new Qf(a, Math.floor(.7 * a)) : new Qf(a, Math.floor(3.44 * a))
	}

	function Wf(a, b) {
		Tf(a, b);
		var c = b.google_content_recommendation_ui_type.split(","),
			d = b.google_content_recommendation_columns_num.split(","),
			e = b.google_content_recommendation_rows_num.split(",");
		a: {
			if(c.length == d.length && d.length == e.length) {
				if(1 == c.length) {
					var f = 0;
					break a
				}
				if(2 == c.length) {
					f = a < Yb ? 0 : 1;
					break a
				}
				throw new L("The parameter length of attribute data-matched-content-ui-type, data-matched-content-columns-num and data-matched-content-rows-num is too long. At most 2 parameters for each attribute are needed: one for mobile and one for desktop, while " + ("you are providing " + c.length + ' parameters. Example: \n data-matched-content-rows-num="4,2"\ndata-matched-content-columns-num="1,6"\ndata-matched-content-ui-type="image_stacked,image_card_sidebyside".'));
			}
			if(c.length != d.length) throw new L('The parameter length of data-matched-content-ui-type does not match data-matched-content-columns-num. Example: \n data-matched-content-rows-num="4,2"\ndata-matched-content-columns-num="1,6"\ndata-matched-content-ui-type="image_stacked,image_card_sidebyside".');
			throw new L('The parameter length of data-matched-content-columns-num does not match data-matched-content-rows-num. Example: \n data-matched-content-rows-num="4,2"\ndata-matched-content-columns-num="1,6"\ndata-matched-content-ui-type="image_stacked,image_card_sidebyside".');
		}
		c = c[f];
		c = 0 == c.lastIndexOf("pub_control_", 0) ? c : "pub_control_" + c;
		d = +d[f];
		for(var g = Pf[c], h = d; a / h < g && 1 < h;) h--;
		h !== d && r.console && r.console.warn("adsbygoogle warning: data-matched-content-columns-num " + d + " is too large. We override it to " + h + ".");
		d = h;
		e = +e[f];
		Uf(b, c, d, e);
		if(Number.isNaN(d) || 0 === d) throw new L("Wrong value for data-matched-content-columns-num");
		if(Number.isNaN(e) || 0 === e) throw new L("Wrong value for data-matched-content-rows-num");
		b = Math.floor(((a - 8 * d - 8) / d * Lf[c] + Nf[c]) * e + 8 * e + 8);
		if(1500 < a) throw new L("Calculated slot width is too large: " + a);
		if(1500 < b) throw new L("Calculated slot height is too large: " + b);
		return new T(9, new Qf(a, b))
	}

	function Tf(a, b) {
		if(0 >= a) throw new L("Invalid responsive width from Matched Content slot " + b.google_ad_slot + ": " + a + ". Please ensure to put this Matched Content slot into a non-zero width div container.");
	}

	function Uf(a, b, c, d) {
		a.google_content_recommendation_ui_type = b;
		a.google_content_recommendation_columns_num = c;
		a.google_content_recommendation_rows_num = d
	};

	function Xf(a, b) {
		N.call(this, a, b)
	}
	ia(Xf, N);
	Xf.prototype.s = function() {
		return this.minWidth()
	};
	Xf.prototype.D = function(a, b, c, d) {
		var e = this.s(b);
		He(a, d, d.parentElement, b, e, c);
		1 != c.google_ad_resize && (d.style.height = this.height() + "px", I(a, ke.c) ? (c.rpe = !1, c.ovlp = !0) : I(a, ke.f) && (c.rpe = !0, c.ovlp = !0))
	};

	function Yf(a) {
		return function(b) {
			for(var c = a.length - 1; 0 <= c; --c)
				if(!a[c](b)) return !1;
			return !0
		}
	}

	function Zf(a, b, c) {
		for(var d = a.length, e = null, f = 0; f < d; ++f) {
			var g = a[f];
			if(b(g)) {
				if(!c || c(g)) return g;
				null === e && (e = g)
			}
		}
		return e
	};
	var U = [new S(970, 90, 2), new S(728, 90, 2), new S(468, 60, 2), new S(336, 280, 1), new S(320, 100, 2), new S(320, 50, 2), new S(300, 600, 4), new S(300, 250, 1), new S(250, 250, 1), new S(234, 60, 2), new S(200, 200, 1), new S(180, 150, 1), new S(160, 600, 4), new S(125, 125, 1), new S(120, 600, 4), new S(120, 240, 4), new S(120, 120, 1, !0)],
		$f = [U[6], U[12], U[3], U[0], U[7], U[14], U[1], U[8], U[10], U[4], U[15], U[2], U[11], U[5], U[13], U[9], U[16]];

	function ag(a, b, c, d, e) {
		"false" != e.google_full_width_responsive || c.location && "#gfwrffwaifhp" == c.location.hash ? "auto" == b || 0 < (De(b) & 1) || "autorelaxed" == b && jc(qc(c), fe.f) || bg(b) || 1 == e.google_ad_resize ? (b = Fe(a, c, d, e), c = !0 !== b ? {
			j: a,
			l: b
		} : {
			j: M(c) || a,
			l: !0
		}) : c = {
			j: a,
			l: 2
		} : c = {
			j: a,
			l: 1
		};
		b = c.l;
		return !0 !== b ? {
			j: a,
			l: b
		} : d.parentElement ? {
			j: c.j,
			l: b
		} : {
			j: a,
			l: b
		}
	}

	function cg(a, b, c, d, e) {
		var f = sd(247, ud, function() {
				return ag(a, b, c, d, e)
			}),
			g = f.j;
		f = f.l;
		var h = !0 === f,
			k = F(d.style.width),
			m = F(d.style.height),
			n = dg(g, b, c, d, e, h);
		g = n.v;
		h = n.u;
		var p = n.K;
		n = n.ta;
		var u = eg(b, p),
			q, H = (q = O(d, c, "marginLeft", F)) ? q + "px" : "",
			aa = (q = O(d, c, "marginRight", F)) ? q + "px" : "";
		q = O(d, c, "zIndex") || "";
		return new T(u, g, p, n, f, h, H, aa, m, k, q)
	}

	function bg(a) {
		return "auto" == a || /^((^|,) *(horizontal|vertical|rectangle) *)+$/.test(a)
	}

	function dg(a, b, c, d, e, f) {
		b = "auto" == b ? .25 >= a / Math.min(1200, M(c)) ? 4 : 3 : De(b);
		var g = !1,
			h = !1,
			k = jc(qc(c), Nd.f);
		if(k && 488 > M(c) || !k && zb()) {
			var m = Ce(d, c);
			var n = Ke(d, c);
			g = !n && m;
			h = n && m
		}
		n = (g || k ? $f : U).slice(0);
		var p = 488 > M(c),
			u = [Ie(a), Je(p, c, d, h), Hf(b)];
		null != e.google_max_responsive_height && u.push(Me(e.google_max_responsive_height));
		k || u.push(fg(p));
		p = [function(a) {
			return !a.sa
		}];
		if(g || h) g = g && !k ? Ne(c, d) : Oe(c, d), p.push(Me(g));
		var q = Zf(n, Yf(u), Yf(p));
		if(!q) throw new L("No slot size for availableWidth=" + a);
		g = sd(248, ud, function() {
			var b;
			a: if(f) {
				if(e.gfwrnh && (b = F(e.gfwrnh))) {
					b = {
						v: new Xf(a, b),
						u: !0
					};
					break a
				}
				if(jc(qc(c), Nd.f) || "true" == e.google_full_width_responsive || !Ke(d, c) || e.google_resizing_allowed) {
					b = a / 1.2;
					var g = e.google_resizing_allowed || "true" == e.google_full_width_responsive ? Infinity : Ne(c, d);
					g = Math.min(b, g);
					if(g < .5 * b || 100 > g) g = b;
					b = {
						v: new Xf(a, Math.floor(g)),
						u: g < b ? 102 : !0
					}
				} else b = {
					v: new Xf(a, q.height()),
					u: 101
				}
			} else b = {
				v: q,
				u: 100
			};
			return b
		});
		return {
			v: g.v,
			u: g.u,
			K: b,
			ta: m
		}
	}

	function eg(a, b) {
		if("auto" == a) return 1;
		switch(b) {
			case 2:
				return 2;
			case 1:
				return 3;
			case 4:
				return 4;
			case 3:
				return 5;
			case 6:
				return 6;
			case 5:
				return 7;
			case 7:
				return 8
		}
		throw Error("bad mask");
	}

	function fg(a) {
		return function(b) {
			return !(320 == b.minWidth() && (a && 50 == b.height() || !a && 100 == b.height()))
		}
	};
	var gg = {
		"image-top": function(a) {
			return 600 >= a ? 284 + .414 * (a - 250) : 429
		},
		"image-middle": function(a) {
			return 500 >= a ? 196 - .13 * (a - 250) : 164 + .2 * (a - 500)
		},
		"image-side": function(a) {
			return 500 >= a ? 205 - .28 * (a - 250) : 134 + .21 * (a - 500)
		},
		"text-only": function(a) {
			return 500 >= a ? 187 - .228 * (a - 250) : 130
		},
		"in-article": function(a) {
			return 420 >= a ? a / 1.2 : 460 >= a ? a / 1.91 + 130 : 800 >= a ? a / 4 : 200
		}
	};

	function hg(a, b) {
		N.call(this, a, b)
	}
	ia(hg, N);
	hg.prototype.s = function() {
		return Math.min(1200, this.minWidth())
	};

	function ig(a, b, c, d, e) {
		var f = e.google_ad_layout || "image-top";
		if("in-article" == f && "false" != e.google_full_width_responsive) {
			var g = Ee(b, c, a, .2, e);
			if(!0 !== g) e.gfwrnwer = g;
			else if(g = M(b)) {
				e.google_full_width_responsive_allowed = !0;
				var h = c.parentElement;
				if(h) {
					b: for(var k = c, m = 0; 100 > m && k.parentElement; ++m) {
						for(var n = k.parentElement.childNodes, p = 0; p < n.length; ++p) {
							var u = n[p];
							if(u != k && Ge(b, u)) break b
						}
						k = k.parentElement;
						k.style.width = "100%";
						k.style.height = "auto"
					}
					He(b, c, h, a, g, e);a = g
				}
			}
		}
		if(250 > a) throw new L("Fluid responsive ads must be at least 250px wide: availableWidth=" + a);
		b = Math.min(1200, Math.floor(a));
		if(d && "in-article" != f) {
			f = Math.ceil(d);
			if(50 > f) throw new L("Fluid responsive ads must be at least 50px tall: height=" + f);
			return new T(11, new N(b, f))
		}
		if("in-article" != f && (d = e.google_ad_layout_key)) {
			f = "" + d;
			d = Math.pow(10, 3);
			if(c = (e = f.match(/([+-][0-9a-z]+)/g)) && e.length) {
				a = [];
				for(g = 0; g < c; g++) a.push(parseInt(e[g], 36) / d);
				d = a
			} else d = null;
			if(!d) throw new L("Invalid data-ad-layout-key value: " + f);
			f = (b + -725) / 1E3;
			e = 0;
			c = 1;
			a = d.length;
			for(g = 0; g < a; g++) e += d[g] * c, c *= f;
			f = Math.ceil(1E3 * e - -725 + 10);
			if(isNaN(f)) throw new L("Invalid height: height=" + f);
			if(50 > f) throw new L("Fluid responsive ads must be at least 50px tall: height=" + f);
			if(1200 < f) throw new L("Fluid responsive ads must be at most 1200px tall: height=" + f);
			return new T(11, new N(b, f))
		}
		d = gg[f];
		if(!d) throw new L("Invalid data-ad-layout value: " + f);
		d = Math.ceil(d(b));
		return new T(11, "in-article" == f ? new hg(b, d) : new N(b, d))
	};

	function V(a, b) {
		N.call(this, a, b)
	}
	ia(V, N);
	V.prototype.s = function() {
		return this.minWidth()
	};
	V.prototype.H = function(a) {
		return N.prototype.H.call(this, a) + "_0ads_al"
	};
	var jg = [new V(728, 15), new V(468, 15), new V(200, 90), new V(180, 90), new V(160, 90), new V(120, 90)];

	function kg(a, b, c) {
		var d = 250,
			e = 90;
		d = void 0 === d ? 130 : d;
		e = void 0 === e ? 30 : e;
		var f = Zf(jg, Ie(a));
		if(!f) throw new L("No link unit size for width=" + a + "px");
		a = Math.min(a, 1200);
		f = f.height();
		b = Math.max(f, b);
		d = (new T(10, new V(a, Math.min(b, 15 == f ? e : d)))).a;
		b = d.minWidth();
		d = d.height();
		15 <= c && (d = c);
		return new T(10, new V(b, d))
	}

	function lg(a, b, c, d) {
		if("false" == d.google_full_width_responsive) return d.google_full_width_responsive_allowed = !1, d.gfwrnwer = 1, a;
		var e = Fe(a, b, c, d);
		if(!0 !== e) return d.google_full_width_responsive_allowed = !1, d.gfwrnwer = e, a;
		e = M(b);
		if(!e) return a;
		d.google_full_width_responsive_allowed = !0;
		He(b, c, c.parentElement, a, e, d);
		return e
	};

	function mg(a, b, c, d, e) {
		var f;
		(f = M(b)) ? 488 > M(b) ? b.innerHeight >= b.innerWidth ? (e.google_full_width_responsive_allowed = !0, He(b, c, c.parentElement, a, f, e), f = {
			j: f,
			l: !0
		}) : f = {
			j: a,
			l: 5
		} : f = {
			j: a,
			l: 4
		}: f = {
			j: a,
			l: 10
		};
		var g = f;
		f = g.j;
		g = g.l;
		if(!0 !== g || a == f) return new T(12, new N(a, d), null, !0, g, 100);
		a = dg(f, "auto", b, c, e, !0);
		return new T(12, a.v, a.K, !0, g, a.u)
	};

	function ng(a) {
		var b = a.google_ad_format;
		if("autorelaxed" == b) return Rf(a) ? 9 : 5;
		if(bg(b)) return 1;
		if("link" == b) return 4;
		if("fluid" == b) return 8
	}

	function og(a, b, c, d, e) {
		e = b.offsetWidth || (c.google_ad_resize || (void 0 === e ? !1 : e)) && O(b, d, "width", F) || c.google_ad_width || 0;
		var f = (f = pg(a, e, b, c, d)) ? f : cg(e, c.google_ad_format, d, b, c);
		f.a.D(d, e, c, b);
		If(f, e, c);
		1 != a && (a = f.a.height(), b.style.height = a + "px")
	}

	function pg(a, b, c, d, e) {
		var f = d.google_ad_height || O(c, e, "height", F);
		switch(a) {
			case 5:
				return a = sd(247, ud, function() {
					return ag(b, d.google_ad_format, e, c, d)
				}), f = a.j, a = a.l, !0 === a && b != f && He(e, c, c.parentElement, b, f, d), !0 === a ? d.google_full_width_responsive_allowed = !0 : (d.google_full_width_responsive_allowed = !1, d.gfwrnwer = a), Sf(f, d);
			case 9:
				return Wf(b, d);
			case 4:
				return a = lg(b, e, c, d), kg(a, Oe(e, c), f);
			case 8:
				return ig(b, e, c, f, d);
			case 10:
				return mg(b, e, c, f, d)
		}
	};

	function W(a) {
		this.h = [];
		this.b = a || window;
		this.a = 0;
		this.g = null;
		this.i = 0
	}
	var qg;
	l = W.prototype;
	l.qa = function(a, b) {
		0 != this.a || 0 != this.h.length || b && b != window ? this.V(a, b) : (this.a = 2, this.da(new rg(a, window)))
	};
	l.V = function(a, b) {
		this.h.push(new rg(a, b || this.b));
		sg(this)
	};
	l.wa = function(a) {
		this.a = 1;
		if(a) {
			var b = td(188, ya(this.ca, this, !0));
			this.g = this.b.setTimeout(b, a)
		}
	};
	l.ca = function(a) {
		a && ++this.i;
		1 == this.a && (null != this.g && (this.b.clearTimeout(this.g), this.g = null), this.a = 0);
		sg(this)
	};
	l.Ba = function() {
		return !(!window || !Array)
	};
	l.ra = function() {
		return this.i
	};

	function sg(a) {
		var b = td(189, ya(a.Da, a));
		a.b.setTimeout(b, 0)
	}
	l.Da = function() {
		if(0 == this.a && this.h.length) {
			var a = this.h.shift();
			this.a = 2;
			var b = td(190, ya(this.da, this, a));
			a.a.setTimeout(b, 0);
			sg(this)
		}
	};
	l.da = function(a) {
		this.a = 0;
		a.b()
	};

	function tg(a) {
		try {
			return a.sz()
		} catch(b) {
			return !1
		}
	}

	function ug(a) {
		return !!a && ("object" === typeof a || "function" === typeof a) && tg(a) && ic(a.nq) && ic(a.nqa) && ic(a.al) && ic(a.rl)
	}

	function vg() {
		if(qg && tg(qg)) return qg;
		var a = Id(),
			b = a.google_jobrunner;
		return ug(b) ? qg = b : a.google_jobrunner = qg = new W(a)
	}

	function wg(a, b) {
		vg().nq(a, b)
	}

	function xg(a, b) {
		vg().nqa(a, b)
	}
	W.prototype.nq = W.prototype.qa;
	W.prototype.nqa = W.prototype.V;
	W.prototype.al = W.prototype.wa;
	W.prototype.rl = W.prototype.ca;
	W.prototype.sz = W.prototype.Ba;
	W.prototype.tc = W.prototype.ra;

	function rg(a, b) {
		this.b = a;
		this.a = b
	};

	function yg(a, b) {
		var c = G(b);
		if(c) {
			c = M(c);
			var d = E(a, b) || {},
				e = d.direction;
			if("0px" === d.width && "none" != d.cssFloat) return -1;
			if("ltr" === e && c) return Math.floor(Math.min(1200, c - a.getBoundingClientRect().left));
			if("rtl" === e && c) return a = b.document.body.getBoundingClientRect().right - a.getBoundingClientRect().right, Math.floor(Math.min(1200, c - a - Math.floor((c - b.document.body.clientWidth) / 2)))
		}
		return -1
	};

	function zg(a) {
		var b = this;
		this.a = a;
		a.google_iframe_oncopy || (a.google_iframe_oncopy = {
			handlers: {},
			upd: function(a, d) {
				var c = Ag("rx", a),
					f = Number;
				a: {
					if(a && (a = a.match("dt=([^&]+)")) && 2 == a.length) {
						a = a[1];
						break a
					}
					a = ""
				}
				f = f(a);
				f = (new Date).getTime() - f;
				c = c.replace(/&dtd=(\d+|-?M)/, "&dtd=" + (1E5 <= f ? "M" : 0 <= f ? f : "-M"));
				b.set(d, c);
				return c
			}
		});
		this.b = a.google_iframe_oncopy
	}
	zg.prototype.set = function(a, b) {
		var c = this;
		this.b.handlers[a] = b;
		this.a.addEventListener && this.a.addEventListener("load", function() {
			var b = c.a.document.getElementById(a);
			try {
				var e = b.contentWindow.document;
				if(b.onload && e && (!e.body || !e.body.firstChild)) b.onload()
			} catch(f) {}
		}, !1)
	};

	function Ag(a, b) {
		var c = new RegExp("\\b" + a + "=(\\d+)"),
			d = c.exec(b);
		d && (b = b.replace(c, a + "=" + (+d[1] + 1 || 1)));
		return b
	}
	var Bg = Ha("var i=this.id,s=window.google_iframe_oncopy,H=s&&s.handlers,h=H&&H[i],w=this.contentWindow,d;try{d=w.document}catch(e){}if(h&&d&&(!d.body||!d.body.firstChild)){if(h.call){setTimeout(h,0)}else if(h.match){try{h=s.upd(h,i)}catch(e){}w.location.replace(h)}}");
	var Cg = {},
		Dg = (Cg.google_ad_modifications = !0, Cg.google_analytics_domain_name = !0, Cg.google_analytics_uacct = !0, Cg.google_pause_ad_requests = !0, Cg);

	function Eg() {
		var a = r;
		this.b = a = void 0 === a ? r : a;
		this.i = "https://securepubads.g.doubleclick.net/static/3p_cookie.html";
		this.a = 2;
		this.g = [];
		this.h = !1;
		a: {
			a = Db(!1, 50);
			var b = Bb(r);b && a.unshift(b);a.unshift(r);
			var c;
			for(b = 0; b < a.length; ++b) try {
				var d = a[b],
					e = Fg(d);
				if(e) {
					this.a = Gg(e);
					if(2 != this.a) break a;
					!c && D(d) && (c = d)
				}
			} catch(f) {}
			this.b = c || this.b
		}
	}

	function Hg(a) {
		if(2 != Ig(a)) {
			for(var b = 1 == Ig(a), c = 0; c < a.g.length; c++) try {
				a.g[c](b)
			} catch(d) {}
			a.g = []
		}
	}

	function Jg(a) {
		var b = Fg(a.b);
		b && 2 == a.a && (a.a = Gg(b))
	}

	function Ig(a) {
		Jg(a);
		return a.a
	}

	function Kg(a) {
		var b = Lg;
		b.g.push(a);
		if(2 != b.a) Hg(b);
		else if(b.h || (Tb(b.b, "message", function(a) {
				var c = Fg(b.b);
				if(c && a.source == c && 2 == b.a) {
					switch(a.data) {
						case "3p_cookie_yes":
							b.a = 1;
							break;
						case "3p_cookie_no":
							b.a = 0
					}
					Hg(b)
				}
			}), b.h = !0), Fg(b.b)) Hg(b);
		else {
			a = wb(new vb(b.b.document), "IFRAME");
			a.src = b.i;
			a.name = "detect_3p_cookie";
			a.style.visibility = "hidden";
			a.style.display = "none";
			a.onload = function() {
				Jg(b);
				Hg(b)
			};
			try {
				b.b.document.body.appendChild(a)
			} catch(c) {}
		}
	}

	function Fg(a) {
		return a.frames && a.frames[Xa("detect_3p_cookie")] || null
	}

	function Gg(a) {
		return Nb(a, "3p_cookie_yes") ? 1 : Nb(a, "3p_cookie_no") ? 0 : 2
	};
	var Mg = /^\.google\.(com?\.)?[a-z]{2,3}$/,
		Ng = /\.(cn|com\.bi|do|sl|ba|by|ma|am)$/;

	function Og(a) {
		return Mg.test(a) && !Ng.test(a)
	}
	var Pg = r,
		Lg;

	function Qg(a) {
		a = "/static/admin/layui/fromOtherWebSite/integrator.js";
		var b = ["domain=" + encodeURIComponent(r.location.hostname)];
		X[3] >= +new Date && b.push("adsid=" + encodeURIComponent(X[1]));
		return a + "?" + b.join("&")
	}
	var X, Y;

	function Rg() {
		Pg = r;
		X = Pg.googleToken = Pg.googleToken || {};
		var a = +new Date;
		X[1] && X[3] > a && 0 < X[2] || (X[1] = "", X[2] = -1, X[3] = -1, X[4] = "", X[6] = "");
		Y = Pg.googleIMState = Pg.googleIMState || {};
		Og(Y[1]) || (Y[1] = ".google.com");
		"array" == ta(Y[5]) || (Y[5] = []);
		na(Y[6]) || (Y[6] = !1);
		"array" == ta(Y[7]) || (Y[7] = []);
		v(Y[8]) || (Y[8] = 0)
	}
	var Z = {
		I: function() {
			return 0 < Y[8]
		},
		ya: function() {
			Y[8]++
		},
		za: function() {
			0 < Y[8] && Y[8]--
		},
		Aa: function() {
			Y[8] = 0
		},
		Oa: function() {
			return !1
		},
		W: function() {
			return Y[5]
		},
		T: function(a) {
			try {
				a()
			} catch(b) {
				r.setTimeout(function() {
					throw b;
				}, 0)
			}
		},
		ba: function() {
			if(!Z.I()) {
				var a = r.document,
					b = function(b) {
						b = Qg(b);
						a: {
							try {
								var c = oa();
								break a
							} catch(g) {}
							c = void 0
						}
						qf(a, b, "preload", "script", c);
						c = a.createElement("script");
						c.type = "text/javascript";
						c.onerror = function() {
							return r.processGoogleToken({}, 2)
						};
						b = xb(b);
						ub(c, b);
						try {
							(a.head || a.body || a.documentElement).appendChild(c), Z.ya()
						} catch(g) {}
					},
					c = Y[1];
				b(c);
				".google.com" != c && b(".google.com");
				b = {};
				var d = (b.newToken = "FBT", b);
				r.setTimeout(function() {
					return r.processGoogleToken(d, 1)
				}, 1E3)
			}
		}
	};

	function Sg(a) {
		Rg();
		var b = Pg.googleToken[5] || 0;
		a && (0 != b || X[3] >= +new Date ? Z.T(a) : (Z.W().push(a), Z.ba()));
		X[3] >= +new Date && X[2] >= +new Date || Z.ba()
	}

	function Tg(a) {
		r.processGoogleToken = r.processGoogleToken || function(a, c) {
			var b = a;
			b = void 0 === b ? {} : b;
			c = void 0 === c ? 0 : c;
			a = b.newToken || "";
			var e = "NT" == a,
				f = parseInt(b.freshLifetimeSecs || "", 10),
				g = parseInt(b.validLifetimeSecs || "", 10),
				h = b["1p_jar"] || "";
			b = b.pucrd || "";
			Rg();
			1 == c ? Z.Aa() : Z.za();
			var k = Pg.googleToken = Pg.googleToken || {},
				m = 0 == c && a && t(a) && !e && v(f) && 0 < f && v(g) && 0 < g && t(h);
			e = e && !Z.I() && (!(X[3] >= +new Date) || "NT" == X[1]);
			var n = !(X[3] >= +new Date) && 0 != c;
			if(m || e || n) e = +new Date, f = e + 1E3 * f, g = e + 1E3 * g, 1E-5 > Math.random() && Ub("https://pagead2.googlesyndication.com/pagead/gen_204?id=imerr&err=" + c, void 0), k[5] = c, k[1] = a, k[2] = f, k[3] = g, k[4] = h, k[6] = b, Rg();
			if(m || !Z.I()) {
				c = Z.W();
				for(a = 0; a < c.length; a++) Z.T(c[a]);
				c.length = 0
			}
		};
		Sg(a)
	}

	function Ug(a) {
		Lg = Lg || new Eg;
		Kg(function(b) {
			b && a()
		})
	};
	var Vg = Xa("script");

	function Wg() {
		var a = !I(C, Wd.C);
		a && C.google_sa_impl && !C.document.getElementById("google_shimpl") && (C.google_sa_queue = null, C.google_sl_win = null, C.google_sa_impl = null);
		a && !C.google_sa_queue && (C.google_sa_queue = [], C.google_sl_win = C, C.google_process_slots = function() {
			return Xg(C)
		}, a = Yg(), qf(C.document, a, "preload", "script"), !x(y, "Chrome") && !x(y, "CriOS") || x(y, "Edge") ? Eb(C.document, a).id = "google_shimpl" : (a = document.createElement("IFRAME"), a.id = "google_shimpl", a.style.display = "none", C.document.documentElement.appendChild(a), Ff(C, "google_shimpl", "<!doctype html><html><body>" + ("<" + Vg + ">") + "google_sl_win=window.parent;google_async_iframe_id='google_shimpl';" + ("</" + Vg + ">") + Zg() + "</body></html>"), a.contentWindow.document.close()))
	}
	var Xg = td(215, function(a) {
		var b = a.google_sa_queue,
			c = b.shift();
		a.google_sa_impl || vd("shimpl", {
			t: "no_fn"
		});
		"function" == ta(c) && sd(216, ud, c);
		b.length && a.setTimeout(function() {
			return Xg(a)
		}, 0)
	});

	function Zg(a) {
		return ["<", Vg, ' src="', Yg(void 0 === a ? "/show_ads_impl.js" : a), '"></', Vg, ">"].join("")
	}

	function Yg(a) {
		a = void 0 === a ? "/show_ads_impl.js" : a;
		var b = bc ? "https" : "http";
		a: {
			if($b) try {
				var c = C.google_cafe_host || C.top.google_cafe_host;
				if(c) {
					var d = c;
					break a
				}
			} catch(e) {}
			d = ec(void 0)
		}
		return Cd(d, ["/pagead/js/", Zb(), "/r20180604", a, ""].join(""), b)
	}

	function $g(a, b, c, d) {
		return function() {
			var e = !1;
			d && vg().al(3E4);
			try {
				Ff(a, b, c), e = !0
			} catch(g) {
				var f = Id().google_jobrunner;
				ug(f) && f.rl()
			}
			e && (e = Ag("google_async_rrc", c), (new zg(a)).set(b, $g(a, b, e, !1)))
		}
	}

	function ah(a) {
		var b = ["<iframe"];
		hc(a, function(a, d) {
			null != a && b.push(" " + d + '="' + Ha(a) + '"')
		});
		b.push("></iframe>");
		return b.join("")
	}

	function bh() {
		return Cd(dc(), ["/pagead/html/", Zb(), "/r20180604/zrt_lookup.html#", encodeURIComponent("")].join(""))
	}

	function ch(a) {
		var b = document.createElement("IFRAME");
		b.id = "google_esf";
		b.name = "google_esf";
		b.src = bh();
		Gb(a, function(a, d) {
			b.setAttribute(d, a)
		});
		return b
	}

	function dh(a, b) {
		if(!Gf) a: {
			for(var c = Db(), d = 0; d < c.length; d++) try {
				var e = c[d].frames.google_esf;
				if(e) {
					Gf = e;
					break a
				}
			} catch(f) {}
			Gf = null
		}
		if(!Gf) {
			c = {};
			c = (c.style = "display:none", c);
			if(/[^a-z0-9-]/.test(a)) return "";
			c["data-ad-client"] = Df(a);
			b ? a = ch(c) : (c.id = "google_esf", c.name = "google_esf", c.src = bh(), a = ah(c));
			return a
		}
		return b ? null : ""
	}

	function eh(a, b, c) {
		fh(a, b, c, function(a, b, f) {
			a = a.document;
			for(var d = b.id, e = 0; !d || a.getElementById(d);) d = "aswift_" + e++;
			b.id = d;
			b.name = d;
			d = Number(f.google_ad_width);
			e = Number(f.google_ad_height);
			var k = f.ds || "";
			k && (k += k.endsWith(";") ? "" : ";");
			16 == f.google_reactive_ad_format ? (f = a.createElement("div"), a = Ef(b, d, e, k), f.innerHTML = a, c.appendChild(f.firstChild)) : (f = Ef(b, d, e, k), c.innerHTML = f);
			return b.id
		})
	}

	function gh(a, b) {
		b = "{iframeWin: window, pubWin: window.parent, vars: " + ("window.parent['google_sv_map']['" + b + "']") + "}";
		if(!I(a, Wd.C)) return "<" + Vg + ">window.parent.google_sa_impl(" + b + ");</" + Vg + ">";
		b = "<" + Vg + ">window.google_process_slots=function(){" + ("window.google_sa_impl(" + b + ");") + ("};</" + Vg + ">");
		a = I(a, Xd.f) ? Zg("/show_ads_impl_le.js") : I(a, Xd.c) ? Zg("/show_ads_impl_le_c.js") : Zg();
		return b + a
	}

	function fh(a, b, c, d) {
		var e = {},
			f = b.google_ad_width,
			g = b.google_ad_height;
		null != f && (e.width = f && '"' + f + '"');
		null != g && (e.height = g && '"' + g + '"');
		e.frameborder = '"0"';
		e.marginwidth = '"0"';
		e.marginheight = '"0"';
		e.vspace = '"0"';
		e.hspace = '"0"';
		e.allowtransparency = '"true"';
		e.scrolling = '"no"';
		e.allowfullscreen = '"true"';
		e.onload = '"' + Bg + '"';
		d = d(a, e, b);
		f = b.google_ad_output;
		e = b.google_ad_format;
		g = b.google_ad_width || 0;
		var h = b.google_ad_height || 0;
		e || "html" != f && null != f || (e = g + "x" + h);
		f = !b.google_ad_slot || b.google_override_format || !ib[b.google_ad_width + "x" + b.google_ad_height] && "aa" == b.google_loader_used;
		e && f ? e = e.toLowerCase() : e = "";
		b.google_ad_format = e;
		if(!v(b.google_reactive_sra_index) || !b.google_ad_unit_key) {
			e = [b.google_ad_slot, b.google_orig_ad_format || b.google_ad_format, b.google_ad_type, b.google_orig_ad_width || b.google_ad_width, b.google_orig_ad_height || b.google_ad_height];
			f = [];
			g = 0;
			for(h = c; h && 25 > g; h = h.parentNode, ++g) 9 === h.nodeType ? f.push("") : f.push(h.id);
			(f = f.join()) && e.push(f);
			b.google_ad_unit_key = Hb(e.join(":")).toString();
			var k = void 0 === k ? !1 : k;
			e = [];
			for(f = 0; c && 25 > f; ++f) {
				g = "";
				void 0 !== k && k || (g = (g = 9 !== c.nodeType && c.id) ? "/" + g : "");
				a: {
					if(c && c.nodeName && c.parentElement) {
						h = c.nodeName.toString().toLowerCase();
						for(var m = c.parentElement.childNodes, n = 0, p = 0; p < m.length; ++p) {
							var u = m[p];
							if(u.nodeName && u.nodeName.toString().toLowerCase() === h) {
								if(c === u) {
									h = "." + n;
									break a
								}++n
							}
						}
					}
					h = ""
				}
				e.push((c.nodeName && c.nodeName.toString().toLowerCase()) + g + h);
				c = c.parentElement
			}
			k = e.join() + ":";
			c = a;
			e = [];
			if(c) try {
				var q = c.parent;
				for(f = 0; q && q !== c && 25 > f; ++f) {
					var H = q.frames;
					for(g = 0; g < H.length; ++g)
						if(c === H[g]) {
							e.push(g);
							break
						}
					c = q;
					q = c.parent
				}
			} catch(aa) {}
			b.google_ad_dom_fingerprint = Hb(k + e.join()).toString()
		}
		H = "";
		I(a, ie.f) ? (q = dh(b.google_ad_client, !0)) && a.document.documentElement.appendChild(q) : H = dh(b.google_ad_client, !1);
		q = !I(a, Wd.C);
		k = Aa;
		c = (new Date).getTime();
		b.google_lrv = Zb();
		b.google_async_iframe_id = d;
		e = a;
		e = gc(fc(e)) || e;
		e = e.google_unique_id;
		b.google_unique_id = "number" === typeof e ? e : 0;
		b.google_start_time = k;
		b.google_bpp = c > k ? c - k : 1;
		b.google_async_rrc = 0;
		a.google_sv_map = a.google_sv_map || {};
		a.google_sv_map[d] = b;
		a.google_t12n_vars = mf;
		H = ["<!doctype html><html><body>", H, "<" + Vg + ">", q ? "google_sl_win=window.parent;" : "", "google_iframe_start_time=new Date().getTime();", 'google_async_iframe_id="' + d + '";', "</" + Vg + ">", gh(a, d), "</body></html>"].join("");
		b = a.document.getElementById(d) ? wg : xg;
		d = $g(a, d, H, !0);
		q ? (a.google_sa_queue = a.google_sa_queue || [], a.google_sa_impl ? b(d) : a.google_sa_queue.push(d)) : b(d)
	}

	function hh(a, b) {
		var c = navigator;
		a && b && c && (a = a.document, b = Df(b), /[^a-z0-9-]/.test(b) || ((c = Ga("r20160913")) && (c += "/"), Eb(a, Cd("pagead2.googlesyndication.com", "/pub-config/" + c + b + ".js"))))
	};

	function ih(a, b) {
		a = a.attributes;
		for(var c = a.length, d = 0; d < c; d++) {
			var e = a[d];
			if(/data-/.test(e.name)) {
				var f = Ga(e.name.replace("data-matched-content", "google_content_recommendation").replace("data", "google").replace(/-/g, "_"));
				if(!b.hasOwnProperty(f)) {
					e = e.value;
					var g = {};
					g = (g.google_reactive_ad_format = Vb, g.google_allow_expandable_ads = Mb, g);
					e = g.hasOwnProperty(f) ? g[f](e, null) : e;
					null === e || (b[f] = e)
				}
			}
		}
	}

	function jh(a, b, c) {
		ih(a, b);
		if(c.document && c.document.body && !ng(b) && !b.google_reactive_ad_format) {
			var d = parseInt(a.style.width, 10),
				e = yg(a, c);
			if(0 < e && d > e) {
				var f = parseInt(a.style.height, 10);
				d = !!ib[d + "x" + f];
				if(I(c, Vd.F)) b.google_ad_resize = 0;
				else {
					var g = e;
					if(d) {
						var h = jb(e, f);
						if(h) g = h, b.google_ad_format = h + "x" + f + "_0ads_al";
						else throw Error("TSS=" + e);
					}
					b.google_ad_resize = 1;
					b.google_ad_width = g;
					d || (b.google_ad_format = null, b.google_override_format = !0);
					e = g;
					a.style.width = e + "px";
					f = cg(e, "auto", c, a, b);
					g = e;
					f.a.D(c, g, b, a);
					If(f, g, b);
					f = f.a;
					b.google_responsive_formats = null;
					f.minWidth() > e && !d && (b.google_ad_width = f.minWidth(), a.style.width = f.minWidth() + "px")
				}
			}
		}
		d = b.google_reactive_ad_format;
		if(!b.google_enable_content_recommendations || 1 != d && 2 != d) {
			d = a.offsetWidth || O(a, c, "width", F) || b.google_ad_width || 0;
			a: {
				e = za(cg, d, "auto", c, a, b, !1, !0);h = I(c, $d.c);
				var k = I(c, $d.f);f = I(c, be.c);g = I(c, be.f);
				var m = uf(c, 11, b.google_ad_client),
					n = I(c, de.f);
				var p = b.google_ad_client;p = null != sf(c, void 0 === p ? "" : p);
				if(!(h || k || m || p) || !zb() || b.google_reactive_ad_format || ng(b) || Ae(a, b) || 1 == b.google_ad_resize || pc(c) != c) d = !1;
				else {
					for(k = a; k; k = k.parentElement)
						if(m = E(k, c), (p = !m) || (p = !(0 <= Ba(["static", "relative"], m.position))), p) {
							d = !1;
							break a
						}
					if(!0 !== Ee(c, a, d, .3, b)) d = !1;
					else {
						b.google_resizing_allowed = !0;
						k = kf(c.location, "google_responsive_slot_debug") || kf(c.location, "google_responsive_slot_preview") || Bf(c, $d.c, $d.f, be.c, be.f);
						m = P(pf(), 142);
						if(k || Math.random() < m) b.ovlp = !0;
						h || g || n ? (h = {}, If(e(), d, h), b.google_resizing_width = h.google_ad_width, b.google_resizing_height = h.google_ad_height, h.ds && (b.ds = h.ds), b.iaaso = !1) : (b.google_ad_format = "auto", b.iaaso = !0);
						(d = f ? "AutoOptimizeAdSizeVariant" : g ? "AutoOptimizeAdSizeOriginal" : null) && (b.google_ad_channel = b.google_ad_channel ? [b.google_ad_channel, d].join("+") : d);
						d = !0
					}
				}
			}
			if(e = ng(b)) og(e, a, b, c, d);
			else {
				if(Ae(a, b)) {
					if(d = E(a, c)) a.style.width = d.width, a.style.height = d.height, ze(d, b);
					b.google_ad_width || (b.google_ad_width = a.offsetWidth);
					b.google_ad_height || (b.google_ad_height = a.offsetHeight);
					b.google_loader_features_used = 256;
					d = fc(c);
					b.google_responsive_auto_format = d ? d.data && "rspv" == d.data.autoFormat ? 13 : 14 : 12
				} else ze(a.style, b), b.google_ad_output && "html" != b.google_ad_output || 300 != b.google_ad_width || 250 != b.google_ad_height || (d = a.style.width, a.style.width = "100%", e = a.offsetWidth, a.style.width = d, b.google_available_width = e);
				c.location && "#gfwmrp" == c.location.hash || 12 == b.google_responsive_auto_format && "true" == b.google_full_width_responsive && !I(c, Ld.f) ? og(10, a, b, c, !1) : I(c, Md.f) && 12 == b.google_responsive_auto_format && (a = Fe(a.offsetWidth || parseInt(a.style.width, 10) || b.google_ad_width, c, a, b), !0 !== a ? (b.efwr = !1, b.gfwrnwer = a) : b.efwr = !0)
			}
		} else b.google_ad_width = M(c), b.google_ad_height = 50, a.style.display = "none"
	};
	var kh = !1,
		lh = 0,
		mh = !1,
		nh = !1,
		oh = !1,
		ph = !1;

	function qh(a) {
		return oc.test(a.className) && "done" != a.getAttribute("data-adsbygoogle-status")
	}

	function rh(a, b) {
		var c = window;
		a.setAttribute("data-adsbygoogle-status", "done");
		sh(a, b, c)
	}

	function sh(a, b, c) {
		var d = nc();
		d.google_spfd || (d.google_spfd = jh);
		(d = b.google_reactive_ads_config) || jh(a, b, c);
		if(!th(a, b, c)) {
			if(d) {
				if(kh) {
					if(d.page_level_pubvars && d.page_level_pubvars.pltais) return;
					throw new L("Only one 'enable_page_level_ads' allowed per page.");
				}
				kh = !0
			} else kc(c);
			mh || (mh = !0, hh(c, b.google_ad_client));
			hc(Dg, function(a, d) {
				b[d] = b[d] || c[d]
			});
			b.google_loader_used = "aa";
			b.google_reactive_tag_first = 1 === lh;
			if((d = b.google_ad_output) && "html" != d) throw new L("No support for google_ad_output=" + d);
			sd(164, ud, function() {
				eh(c, b, a)
			})
		}
	}

	function th(a, b, c) {
		var d = b.google_reactive_ads_config;
		if(d) {
			var e = d.page_level_pubvars;
			e = (va(e) ? e : {}).google_tag_origin
		}
		if("js" === b.google_ad_output) return !1;
		var f = e || b.google_tag_origin;
		e = t(a.className) && /(\W|^)adsbygoogle-noablate(\W|$)/.test(a.className);
		var g = b.google_ad_slot;
		var h = c.google_ad_modifications;
		!h || sc(h.ad_whitelist, g, f) ? h = null : (f = h.space_collapsing || "none", h = (g = sc(h.ad_blacklist, g)) ? {
			P: !0,
			fa: g.space_collapsing || f
		} : h.remove_ads_by_default ? {
			P: !0,
			fa: f,
			pa: h.dont_remove_atf
		} : null);
		if(e = h && h.P && "on" != b.google_adtest && !e) {
			a: {
				try {
					if(a.parentNode && 0 < a.offsetWidth && 0 < a.offsetHeight && a.style && "none" !== a.style.display && "hidden" !== a.style.visibility && (!a.style.opacity || 0 !== Number(a.style.opacity))) {
						var k = a.getBoundingClientRect();
						var m = 0 < k.right && 0 < k.bottom;
						break a
					}
				} catch(n) {}
				m = !1
			}
			m && (m = Be(a, c) < re(c).clientHeight);e = !(m && h.pa)
		}
		if(e) return a.className += " adsbygoogle-ablated-ad-slot", c = c.google_sv_map = c.google_sv_map || {}, b.google_ad_slot && (c[b.google_ad_slot] = b, a.setAttribute("google_ad_slot", b.google_ad_slot)), "slot" == h.fa && (null !== Lb(a.getAttribute("width")) && a.setAttribute("width", 0), null !== Lb(a.getAttribute("height")) && a.setAttribute("height", 0), a.style.width = "0px", a.style.height = "0px"), !0;
		if((m = E(a, c)) && "none" == m.display && !("on" == b.google_adtest || 0 < b.google_reactive_ad_format || d)) return c.document.createComment && a.appendChild(c.document.createComment("No ad requested because of display:none on the adsbygoogle tag")), !0;
		a = null == b.google_pgb_reactive || 3 === b.google_pgb_reactive;
		return 1 !== b.google_reactive_ad_format && 8 !== b.google_reactive_ad_format || !a ? !1 : (r.console && r.console.warn("Adsbygoogle tag with data-reactive-ad-format=" + b.google_reactive_ad_format + " is deprecated. Check out page-level ads at https://www.google.com/adsense"), !0)
	}

	function uh(a) {
		var b = document.getElementsByTagName("INS");
		for(var c = 0, d = b[c]; c < b.length; d = b[++c]) {
			var e = d;
			if(qh(e) && "reserved" != e.getAttribute("data-adsbygoogle-status") && (!a || d.id == a)) return d
		}
		return null
	}

	function vh() {
		var a = document.createElement("INS");
		a.className = "adsbygoogle";
		a.className += " adsbygoogle-noablate";
		Ob(a);
		return a
	}

	function wh(a) {
		var b = {};
		hc(tc, function(c, d) {
			!1 === a.enable_page_level_ads ? b[d] = !1 : a.hasOwnProperty(d) && (b[d] = a[d])
		});
		va(a.enable_page_level_ads) && (b.page_level_pubvars = a.enable_page_level_ads);
		var c = vh();
		hb.body.appendChild(c);
		var d = {};
		d = (d.google_reactive_ads_config = b, d.google_ad_client = a.google_ad_client, d);
		d.google_pause_ad_requests = oh;
		rh(c, d)
	}

	function xh(a) {
		function b() {
			return wh(a)
		}
		var c = G(window);
		if(!c) throw new L("Page-level tag does not work inside iframes.");
		qe(c).wasPlaTagProcessed = !0;
		hb.body || "complete" == hb.readyState || "interactive" == hb.readyState ? b() : Tb(hb, "DOMContentLoaded", md(191, b))
	}

	function yh(a) {
		var b = {};
		sd(165, wd, function() {
			zh(a, b)
		}, function(c) {
			c.client = c.client || b.google_ad_client || a.google_ad_client;
			c.slotname = c.slotname || b.google_ad_slot;
			c.tag_origin = c.tag_origin || b.google_tag_origin
		})
	}

	function zh(a, b) {
		Aa = (new Date).getTime();
		Wg();
		a: {
			if(void 0 != a.enable_page_level_ads) {
				if(t(a.google_ad_client)) {
					var c = !0;
					break a
				}
				throw new L("'google_ad_client' is missing from the tag config.");
			}
			c = !1
		}
		c ? Ah(a, b) : ((c = a.params) && hc(c, function(a, c) {
			b[c] = a
		}), "js" === b.google_ad_output ? console.warn("Ads with google_ad_output='js' have been deprecated and no longer work. Contact your AdSense account manager or switch to standard AdSense ads.") : (a = Bh(a.element), ih(a, b), 0 === lh && wf(b) && (c = rf(b.google_ad_client), Ah(c), ph = !0), 0 === lh && (lh = 2), b.google_pause_ad_requests = oh, rh(a, b)))
	}

	function Ah(a, b) {
		if(ph) ph = !1;
		else {
			0 === lh && (lh = 1);
			b && a.tag_partner && (rc(r, a.tag_partner), rc(b, a.tag_partner));
			if(!nh) {
				nh = !0;
				try {
					var c = r.localStorage.getItem("google_ama_config")
				} catch(xc) {
					c = null
				}
				try {
					var d = c ? new Dc(c ? JSON.parse(c) : null) : null
				} catch(xc) {
					d = null
				}
				if(b = d)
					if(c = bb(b, Fc, 3), !c || B(c, 1) <= +new Date) try {
						r.localStorage.removeItem("google_ama_config")
					} catch(xc) {
						Bd(r, {
							lserr: 1
						})
					} else {
						if(bb(b, Ic, 13)) switch(c = !0, B(bb(b, Ic, 13), 1)) {
							case 1:
							case 2:
							case 3:
								c = !1;
							case 4:
								d = r.google_ad_modifications = r.google_ad_modifications || {}, d.remove_ads_by_default = !0, d.space_collapsing = "slot", d.dont_remove_atf = void 0 === c ? !1 : c
						}
						Fd(3, [db(b)]);
						c = a.google_ad_client;
						d = Ad;
						if(a.enable_page_level_ads && a.enable_page_level_ads.google_ad_channel) {
							var e = {};
							e = new yd(null, (e.google_ad_channel = a.enable_page_level_ads.google_ad_channel, e));
							d = zd(d, e)
						}
						try {
							var f = ab(b, 5);
							if(0 < f.length) {
								var g = new Gc,
									h = f || [];
								2 < g.i ? g.b[2 + g.h] = h : ($a(g), g.g[2] = h);
								var k = g
							} else b: {
								h = r.location.pathname;
								var m = cb(b, Gc, 7);g = {};
								for(f = 0; f < m.length; ++f) {
									var n = B(m[f], 1);
									v(n) && !g[n] && (g[n] = m[f])
								}
								for(var p = h.replace(/(^\/)|(\/$)/g, "");;) {
									var u = Hb(p);
									if(g[u]) {
										k = g[u];
										break b
									}
									if(!p) {
										k = null;
										break b
									}
									p = p.substring(0, p.lastIndexOf("/"))
								}
							}
							var q;
							if(q = k) a: {
								var H = ab(k, 2);
								if(H)
									for(h = 0; h < H.length; h++)
										if(1 == H[h]) {
											q = !0;
											break a
										}
								q = !1
							}
							if(q) {
								if(B(k, 4)) {
									q = {};
									var aa = new yd(null, (q.google_package = B(k, 4), q));
									d = zd(d, aa)
								}
								var sa = new $e;
								(new ef(new Xe(c, b, d), sa)).start();
								var Qa = sa.b;
								var Dh = za(hf, r);
								if(Qa.b) throw Error("Then functions already set.");
								Qa.b = za(gf, r);
								Qa.g = Dh;
								cf(Qa)
							}
						} catch(xc) {
							Bd(r, {
								atf: -1
							})
						}
					}
			}
			xh(a)
		}
	}

	function Bh(a) {
		if(a) {
			if(!qh(a) && (a.id ? a = uh(a.id) : a = null, !a)) throw new L("'element' has already been filled.");
			if(!("innerHTML" in a)) throw new L("'element' is not a good DOM element.");
		} else if(a = uh(), !a) throw new L("All ins elements in the DOM with class=adsbygoogle already have ads in them.");
		return a
	}

	function Ch() {
		pd();
		sd(166, xd, Eh)
	}

	function Eh() {
		var a = gc(fc(C)) || C,
			b = a.google_ad_modifications = a.google_ad_modifications || {};
		if(!b.plle) {
			b.plle = !0;
			var c = b.eids = b.eids || [];
			b = b.loeids = b.loeids || [];
			var d = pf();
			var e = pf();
			var f = G(a) || a;
			f = kf(f.location, "google_responsive_slot_debug") || kf(f.location, "google_responsive_slot_preview");
			var g = uf(a, 11),
				h = null != sf(a, "");
			f ? (f = $d, g = ae, e = f.f) : h ? (f = de, g = ee, e = Cf(a, new Wc(0, 999), P(e, 152), P(e, 153), [f.c, f.f], 2)) : g ? (f = be, g = ce, e = Cf(a, new Wc(0, 999), P(e, 120), P(e, 121), [f.c, f.f], 2)) : (f = $d, g = ae, e = Cf(a, zf, P(e, 96), P(e, 97), [f.c, f.f]));
			e ? (h = {}, f = (h[f.c] = g.c, h[f.f] = g.f, h)[e], e = {
				va: e,
				xa: f
			}) : e = null;
			f = e || {};
			e = f.va;
			f = f.xa;
			e && f && (Q(c, e), Q(c, f));
			g = Ld;
			e = R(a, P(d, 136), [g.c, g.f]);
			Q(c, e);
			uf(a, 12) && (g = Kd, h = Jd, e = Cf(a, new Wc(0, 999), P(d, 149), P(d, 150), [g.c, g.f], 4), Q(b, e), e == g.c ? f = h.c : e == g.f ? f = h.f : f = "", Q(c, f));
			g = Pd;
			Q(c, Cf(a, xf, P(d, 9), P(d, 10), [g.c, g.ka]));
			Ga("") && Q(b, "");
			g = Vd;
			e = R(a, P(d, 11), [g.c, g.F]);
			Q(c, e);
			h = "";
			e === g.c ? h = "62710018" : e === g.F && (h = "62710017");
			Q(c, h);
			g = Wd;
			e = R(a, P(d, 156), [g.c, g.C]);
			Q(c, e);
			g = je;
			e = R(a, P(d, 146), [g.c, g.f]);
			Q(c, e);
			g = Xd;
			e = R(a, P(d, 56), [g.c, g.f]);
			Q(c, e);
			g = Qd;
			e = R(a, P(d, 13), [g.m, g.c]);
			Q(c, e);
			e = R(a, 0, [g.L]);
			Q(c, e);
			g = Rd;
			e = R(a, P(d, 60), [g.m, g.c]);
			Q(c, e);
			e == Rd.m && (g = Sd, e = R(a, P(d, 66), [g.m, g.c]), Q(c, e), g = Ud, e = R(a, P(d, 137), [g.m, g.c]), Q(c, e), e == Sd.m && (g = Td, e = R(a, P(d, 135), [g.m, g.c]), Q(c, e)));
			g = Md;
			e = R(a, P(d, 98), [g.c, g.f]);
			Q(c, e);
			if(Mb(d.a[77], !1) || $b) g = Yd, e = R(a, P(d, 76), [g.c, g.O, g.G, g.N]), Q(c, e), e || (e = R(a, P(d, 83), [g.M]), Q(c, e));
			g = Nd;
			e = Cf(a, Af, P(d, 157), P(d, 158), [g.c, g.f]);
			Q(b, e);
			h = Od;
			e == g.c ? f = h.c : e == g.f ? f = h.f : f = "";
			Q(c, f);
			g = Zd;
			e = R(a, P(d, 92), [g.c, g.f]);
			Q(c, e);
			g = fe;
			e = Cf(a, yf, P(d, 99), P(d, 100), [g.c, g.f]);
			Q(b, e);
			h = ge;
			e == g.c ? f = h.c : e == g.f ? f = h.f : f = "";
			Q(c, f);
			g = he;
			e = R(a, P(d, 127), [g.c, g.ia, g.ja]);
			Q(c, e);
			g = ie;
			e = R(a, P(d, 141), [g.f, g.c]);
			Q(c, e);
			g = ke;
			e = R(a, P(d, 151), [g.c, g.f]);
			Q(c, e)
		}
		od(I(C, Sd.m) || I(C, Qd.m) || I(C, Qd.L));
		if(I(C, Yd.O) || I(C, Yd.G) || I(C, Yd.N) || I(C, Yd.M)) Rg(), Og(".google.cn") && (Y[1] = ".google.cn"), I(C, Yd.G) ? (a = mb(), Ug(a), Tg(a)) : Tg(null);
		I(C, Zd.f) && (a = ne() ? Xb("", "pagead2.googlesyndication.com") : dc(), qf(nc().document, a, "preconnect"));
		if(a = G(r)) a = qe(a), va(a.tagSpecificState) && a.tagSpecificState[1] || !va(a.tagSpecificState) || (a.tagSpecificState[1] = new jf);
		a = window.adsbygoogle;
		if(!a || !a.loaded) {
			c = {
				push: yh,
				loaded: !0
			};
			try {
				Object.defineProperty(c, "requestNonPersonalizedAds", {
					set: Fh
				}), Object.defineProperty(c, "pauseAdRequests", {
					set: Gh
				}), Object.defineProperty(c, "onload", {
					set: Hh
				})
			} catch(m) {}
			a && (void 0 !== a.requestNonPersonalizedAds && (c.requestNonPersonalizedAds = a.requestNonPersonalizedAds), void 0 !== a.pauseAdRequests && (c.pauseAdRequests = a.pauseAdRequests));
			if(a && a.shift) try {
				var k;
				for(b = 20; 0 < a.length && (k = a.shift()) && 0 < b;) yh(k), --b
			} catch(m) {
				throw window.setTimeout(Ch, 0), m;
			}
			window.adsbygoogle = c;
			a && (c.onload = a.onload)
		}
	}

	function Fh(a) {
		if(+a) {
			if((a = Cb()) && a.frames && !a.frames.GoogleSetNPA) try {
				var b = a.document,
					c = new vb(b),
					d = b.body || b.head && b.head.parentElement;
				if(d) {
					var e = wb(c, "IFRAME");
					e.name = "GoogleSetNPA";
					e.id = "GoogleSetNPA";
					e.setAttribute("style", "display:none;position:fixed;left:-999px;top:-999px;width:0px;height:0px;");
					d.appendChild(e)
				}
			} catch(f) {}
		} else(b = Cb().document.getElementById("GoogleSetNPA")) && b.parentNode && b.parentNode.removeChild(b)
	}

	function Gh(a) {
		+a ? oh = !0 : (oh = !1, a = function() {
			if(!oh) {
				var a = nc(),
					c = nc();
				try {
					if(hb.createEvent) {
						var d = hb.createEvent("CustomEvent");
						d.initCustomEvent("adsbygoogle-pub-unpause-ad-requests-event", !1, !1, "");
						a.dispatchEvent(d)
					} else if(ic(c.CustomEvent)) {
						var e = new c.CustomEvent("adsbygoogle-pub-unpause-ad-requests-event", {
							bubbles: !1,
							cancelable: !1,
							detail: ""
						});
						a.dispatchEvent(e)
					} else if(ic(c.Event)) {
						var f = new Event("adsbygoogle-pub-unpause-ad-requests-event", {
							bubbles: !1,
							cancelable: !1
						});
						a.dispatchEvent(f)
					}
				} catch(g) {}
			}
		}, r.setTimeout(a, 0), r.setTimeout(a, 1E3))
	}

	function Hh(a) {
		ic(a) && window.setTimeout(a, 0)
	};
	Ch();
}).call(this);